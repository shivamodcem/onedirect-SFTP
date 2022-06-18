package com.onedirect.sftp.service.Impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onedirect.commonutils.pojos.ApiResponse;
import com.onedirect.commonutils.utils.http.HttpUtil;
import com.onedirect.sftp.DTO.ThirdPartyDto.ThirdPartyTicketInputDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.TicketResponseDto;
import com.onedirect.sftp.config.ThirdPartyApiConfig;
import com.onedirect.sftp.service.SendToThirdParty;
import com.onedirect.sftp.util.HttpClientUtil;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendToThirdPartyImpl implements SendToThirdParty {
    @Autowired
    ThirdPartyApiConfig thirdPartyApiConfig;
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static Logger LOG = LogManager.getLogger(SendToThirdPartyImpl.class);
    @Override
    public Boolean SendTicket( MultiValueMap<String, Object> thirdPartyTicketInputDto) {
            Map<String, String> reqHeaders = new HashMap<>();
            reqHeaders.put("brandId", thirdPartyApiConfig.getBrandId().toString());
            reqHeaders.put("brandUserId", thirdPartyApiConfig.getBrandUserId().toString());
            try {
                ApiResponse<TicketResponseDto> ticketResponse = HttpUtil.post(thirdPartyApiConfig.getUrl(),
                        thirdPartyTicketInputDto,
                        reqHeaders, TicketResponseDto.class);
                if (HttpStatus.valueOf(ticketResponse.getHttpStatus().value()).is2xxSuccessful()) {
                    LOG.info(ticketResponse.getBody().toString());
                    return true;
                } else {
                    LOG.error("Error while creating Thirdparty Ticket {}",ticketResponse.getBody().toString() );
                   return false;
                }
            } catch (Exception e) {
                LOG.error("Error while creating Thirdparty Ticket : {}", e.getMessage());
               return false;
            }
        }
    }
