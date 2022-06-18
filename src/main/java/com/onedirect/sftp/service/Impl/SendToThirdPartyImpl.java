package com.onedirect.sftp.service.Impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onedirect.sftp.DTO.ThirdPartyDto.ThirdPartyTicketInputDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.TicketResponseDto;
import com.onedirect.sftp.config.ThirdPartyApiConfig;
import com.onedirect.sftp.service.SendToThirdParty;
import com.onedirect.sftp.util.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendToThirdPartyImpl implements SendToThirdParty {
    @Autowired
    ThirdPartyApiConfig thirdPartyApiConfig;
    private static final Gson gson = new GsonBuilder().serializeNulls().create();
    private static Logger LOG = LogManager.getLogger(HttpClientUtil.class);
    @Override
    public Boolean SendTicket(List<NameValuePair> thirdPartyTicketInputDto) {
        try{
            Map<String, String> reqHeaders = new HashMap<>();
            reqHeaders.put("brandId", thirdPartyApiConfig.getBrandId().toString());
            reqHeaders.put("brandUserId", thirdPartyApiConfig.getBrandUserId().toString());
            TicketResponseDto data = HttpClientUtil.post(thirdPartyApiConfig.getUrl(),thirdPartyTicketInputDto,TicketResponseDto.class,reqHeaders);
            LOG.info("The received DTO from thirdPart Api is: {}",data);
            return true;
        }
        catch (Exception ex)
        {
            LOG.error("Exception occurred while sending to ThirdParty with {}",ex);
            return false;
        }


    }
}
