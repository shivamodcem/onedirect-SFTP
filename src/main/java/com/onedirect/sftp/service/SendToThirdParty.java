package com.onedirect.sftp.service;

import com.onedirect.sftp.DTO.ThirdPartyDto.ThirdPartyTicketInputDto;
import org.apache.http.NameValuePair;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.List;

public interface SendToThirdParty {
    Boolean SendTicket(MultiValueMap<String, Object> thirdPartyTicketInputNamValuePair) throws IOException;
}
