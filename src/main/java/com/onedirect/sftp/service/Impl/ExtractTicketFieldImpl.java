package com.onedirect.sftp.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onedirect.sftp.DTO.TicketFieldBrandDto.TicketFieldDTO;
import com.onedirect.sftp.config.InterCommConfig;
import com.onedirect.sftp.service.ExtractTicketField;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@PropertySource("classpath:application.properties")
@Service
public class ExtractTicketFieldImpl implements ExtractTicketField {
    private static final Logger log = LoggerFactory.getLogger(ExtractBrandUsersImpl.class);
    @Autowired
    private InterCommConfig interCommConfig;

    @Value("#{${brandapi.url}}")
    String brandApiUrl;

    @Override
    public List<TicketFieldDTO> getTotalTicketFields() {
        List<TicketFieldDTO> ticketFieldDTOS=new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String url = brandApiUrl+"/" + interCommConfig.getBrandId().toString() +"/ticketFields";
            HttpGet request = new HttpGet(url);
            request.addHeader("brandId",interCommConfig.getBrandId().toString());
            request.addHeader("brandUserId",interCommConfig.getBrandUserId().toString());
            request.addHeader("productId",interCommConfig.getProductId().toString());

            log.info("brandApi.url : {} " , url);
            try {
                HttpResponse response = httpClient.execute(request);
                if(response.getStatusLine().getStatusCode() <= 300 ) {
                    HttpEntity entity = response.getEntity();
                    if(null != entity )
                    {

                        String ticketFields = EntityUtils.toString(response.getEntity());
                        ObjectMapper objectMapper = new ObjectMapper();
                        ticketFieldDTOS = objectMapper.readValue(ticketFields, new TypeReference<List<TicketFieldDTO>>(){});
                        log.info("TicketFieldData is {}",ticketFieldDTOS);
                    }
                }
                else{
                    log.info("Status Code {} recieved from BrandApi is",response.getStatusLine().getStatusCode());
                }
            }
            catch (Exception exc) {
                log.info("The following error occurred : {}", exc.getMessage());
                return ticketFieldDTOS;
            }


        } catch (Exception e) {
            log.info("Couldnt Create HTTP client");
            throw new RuntimeException(e);
        }
        return ticketFieldDTOS;

    }
    @Override
    public HashMap<String,TicketFieldDTO> dtoToMap(List<TicketFieldDTO> ticketFieldDTOList)
    {
        HashMap<String,TicketFieldDTO> map=new HashMap<>();
        if(ticketFieldDTOList !=null && !ticketFieldDTOList.isEmpty())
        {
            for(TicketFieldDTO dto:ticketFieldDTOList)
            {
                map.put(dto.getFieldTitle(),dto);
            }
        }
        return map;
    }

}
