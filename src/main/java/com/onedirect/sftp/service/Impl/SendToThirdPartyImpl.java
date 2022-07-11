package com.onedirect.sftp.service.Impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onedirect.commonutils.pojos.ApiResponse;
import com.onedirect.commonutils.utils.http.HttpUtil;
import com.onedirect.sftp.DTO.ThirdPartyDto.TicketResponseDto;
import com.onedirect.sftp.config.InterCommConfig;
import com.onedirect.sftp.service.SendToThirdParty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
@PropertySource("classpath:application.properties")
@Service
public class SendToThirdPartyImpl implements SendToThirdParty {
    @Autowired
    private InterCommConfig interCommConfig;

    @Value("#{${thirdparty.url}}")
    String thirdPartyUrl;

    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static final Logger LOG = LoggerFactory.getLogger(SendToThirdPartyImpl.class);
    @Override
    public String SendTicket(MultiValueMap<String, Object> thirdPartyTicketInputDto) {
            Map<String, String> reqHeaders = new HashMap<>();
            reqHeaders.put("brandId", interCommConfig.getBrandId().toString());
            reqHeaders.put("brandUserId", interCommConfig.getBrandUserId().toString());
            try {
                ApiResponse<TicketResponseDto> ticketResponse = HttpUtil.post(thirdPartyUrl,
                        thirdPartyTicketInputDto,
                        reqHeaders, TicketResponseDto.class);
                if (HttpStatus.valueOf(ticketResponse.getHttpStatus().value()).is2xxSuccessful()) {
                    return ticketResponse.getBody().toString();
                } else {
                   throw new RuntimeException(ticketResponse.getBody().toString());
                }
            } catch (Exception e) {
                LOG.error("Error while creating Thirdparty Ticket : {}", e.getMessage());
                throw new RuntimeException(e.getMessage());
            }
        }
    }
