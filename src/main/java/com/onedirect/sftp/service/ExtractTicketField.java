package com.onedirect.sftp.service;

import com.onedirect.sftp.DTO.TicketFieldBrandDto.TicketFieldDTO;

import java.util.List;
import java.util.Map;

public interface ExtractTicketField {
    List<TicketFieldDTO> getTotalTicketFields();
    Map<String,TicketFieldDTO> dtoToMap(List<TicketFieldDTO> ticketFieldDTOList);
}
