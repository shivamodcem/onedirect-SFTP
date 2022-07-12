package com.onedirect.sftp.service.Impl;

        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDetailedDto;
        import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDto;
        import com.onedirect.sftp.config.InterCommConfig;
        import com.onedirect.sftp.service.ExtractCustomerField;
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

        import java.util.HashMap;
@PropertySource("classpath:application.properties")
@Service
public class ExtractCustomerFieldImpl implements ExtractCustomerField {
    private static final Logger log = LoggerFactory.getLogger(ExtractCustomerFieldImpl.class);
    @Autowired
    private InterCommConfig interCommConfig;

    @Value("${cust.url}")
    String custUrl;
    @Override
    public CustomerFieldDetailedDto getCustomerField() {
        CustomerFieldDetailedDto customerFieldDetailedDtos=null;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            String url = custUrl;
            HttpGet request = new HttpGet(url);
            request.addHeader("brandId", interCommConfig.getBrandId().toString());
            request.addHeader("brandUserId", interCommConfig.getBrandUserId().toString());
            request.addHeader("productId", interCommConfig.getProductId().toString());

            log.info("BrandApi.url for customer field is : {} " , url);
            try {
                HttpResponse response = httpClient.execute(request);
                if(response.getStatusLine().getStatusCode() <= 300 ) {
                    HttpEntity entity = response.getEntity();
                    if(null != entity )
                    {

                        String customerField = EntityUtils.toString(response.getEntity());
                        ObjectMapper objectMapper = new ObjectMapper();
                        customerFieldDetailedDtos = objectMapper.readValue(customerField, CustomerFieldDetailedDto.class);
                        log.info("CustomerFieldData is {}",customerFieldDetailedDtos.toString());
                    }
                }
                else{
                    log.info("Status Code {} recieved from BrandApi is",response.getStatusLine().getStatusCode());
                }
            }
            catch (Exception exc) {
                log.info("The following error occurred : {}",exc.getMessage());
                return customerFieldDetailedDtos;
            }


        } catch (Exception e) {
            log.info("Couldnt Create HTTP client");
            throw new RuntimeException(e);
        }
        return customerFieldDetailedDtos;

    }
    @Override
    public HashMap<String, CustomerFieldDto> ObjectToMap(CustomerFieldDetailedDto customerFieldDetailedDto)
    {
        HashMap<String, CustomerFieldDto> customerFieldDetailedDtoMap=new HashMap<>();
        if(customerFieldDetailedDto!=null && customerFieldDetailedDto.getCustomerFields()!=null && !customerFieldDetailedDto.getCustomerFields().isEmpty())
        {
            for(CustomerFieldDto customerFieldDto: customerFieldDetailedDto.getCustomerFields())
            {
                customerFieldDetailedDtoMap.put(customerFieldDto.getFieldTitle(),customerFieldDto);
            }
        }
        return customerFieldDetailedDtoMap;
    }

}
