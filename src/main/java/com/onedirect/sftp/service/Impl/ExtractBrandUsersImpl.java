package com.onedirect.sftp.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onedirect.sftp.DTO.BrandUserDto.BrandUserDto;
import com.onedirect.sftp.config.BrandApiConfig;
import com.onedirect.sftp.config.IsApiConfig;
import com.onedirect.sftp.service.ExtractBrandUsers;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExtractBrandUsersImpl implements ExtractBrandUsers {
    private static final Logger log = LoggerFactory.getLogger(ExtractBrandUsersImpl.class);
    @Autowired
    private IsApiConfig isApiConfig;
    @Override
    public List<BrandUserDto> getTotalUsers() {
        List<BrandUserDto> brandUserData=new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String url = isApiConfig.getUrl()+"?brand-id=" + isApiConfig.getBrandId().toString() +"&product-id=" +isApiConfig.getProductId().toString();
            HttpGet request = new HttpGet(url);
            request.addHeader("brandId",isApiConfig.getBrandId().toString());
            request.addHeader("brandUserId",isApiConfig.getBrandUserId().toString());
            request.addHeader("productId",isApiConfig.getProductId().toString());

            log.info("isapi.url : {} " , url);
            try {
                HttpResponse response = httpClient.execute(request);
                if(response.getStatusLine().getStatusCode() <= 300 ) {
                    HttpEntity entity = response.getEntity();
                    if(null != entity )
                    {

                        String brandUserDataResponse = EntityUtils.toString(response.getEntity());
                        ObjectMapper objectMapper = new ObjectMapper();
                        brandUserData = objectMapper.readValue(brandUserDataResponse, new TypeReference<List<BrandUserDto>>(){});
                        log.info("BrandUserData is {}",brandUserData);
                    }
                }
                else{
                    log.info("Status Code {} recieved from isApi is",response.getStatusLine().getStatusCode());
                }
            }
            catch (Exception exc) {
                log.info("The following error occurred : {}", exc.getMessage());
                return brandUserData;
            }


        } catch (Exception e) {
            log.info("Couldnt Create HTTP client");
            throw new RuntimeException(e);
        }
        return brandUserData;

    }
    @Override
    public HashMap<String, Integer>  ObjectToMap(List<BrandUserDto> brandUserDtoList) {
        HashMap<String, Integer> brandUserDtoMap=new HashMap<>();
        for(BrandUserDto brandUserDto: brandUserDtoList)
        {
            brandUserDtoMap.put(brandUserDto.getEmail().toLowerCase().trim(),brandUserDto.getId());
        }
        return brandUserDtoMap;
    }
}
