package com.onedirect.sftp.service;

import com.onedirect.sftp.DTO.ThirdPartyDto.ThirdPartyTicketInputDto;
import org.apache.http.NameValuePair;

import java.io.IOException;
import java.util.List;

public interface SendToThirdParty {
    Boolean SendTicket(List<NameValuePair> thirdPartyTicketInputNamValuePair) throws IOException;
}
