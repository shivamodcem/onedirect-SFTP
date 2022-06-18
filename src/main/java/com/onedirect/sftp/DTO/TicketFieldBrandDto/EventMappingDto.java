package com.onedirect.sftp.DTO.TicketFieldBrandDto;

import java.util.List;

public class EventMappingDto {

  private Byte eventId;
  private List<Byte> ticketTypes;

  public EventMappingDto() {
  }

  public EventMappingDto(Byte eventId, List<Byte> ticketTypes) {
    this.eventId = eventId;
    this.ticketTypes = ticketTypes;
  }

  public Byte getEventId() {
    return eventId;
  }

  public void setEventId(Byte eventId) {
    this.eventId = eventId;
  }

  public List<Byte> getTicketTypes() {
    return ticketTypes;
  }

  public void setTicketTypes(List<Byte> ticketTypes) {
    this.ticketTypes = ticketTypes;
  }
}
