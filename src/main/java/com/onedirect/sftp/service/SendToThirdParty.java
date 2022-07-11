package com.onedirect.sftp.service;

import org.springframework.util.MultiValueMap;

import java.io.IOException;

public interface SendToThirdParty {
    String SendTicket(MultiValueMap<String, Object> thirdPartyTicketInputNamValuePair) throws IOException;
}
