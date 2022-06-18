package com.onedirect.sftp.DTO.ThirdPartyDto;

import java.util.List;


public class TicketFieldDto {

  private Long id;
  private Integer customLabelId;
  private List<TicketFieldValuesDataDto> ticketFieldValuesDataList;
  private Byte fieldType;

  public List<TicketFieldValuesDataDto> getTicketFieldValuesDataList() {
    return ticketFieldValuesDataList;
  }

  public void setTicketFieldValuesDataList(
          List<TicketFieldValuesDataDto> ticketFieldValuesDataList) {
    this.ticketFieldValuesDataList = ticketFieldValuesDataList;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getCustomLabelId() {
    return customLabelId;
  }

  public void setCustomLabelId(Integer customLabelId) {
    this.customLabelId = customLabelId;
  }


  public Byte getFieldType() {
    return fieldType;
  }

  public void setFieldType(Byte fieldType) {
    this.fieldType = fieldType;
  }

  @Override
  public String toString() {
    return "TicketFieldDto{"
            + "id=" + id
            + ", customLabelId=" + customLabelId
            + ", ticketFieldValuesDataList=" + ticketFieldValuesDataList
            + ", fieldType=" + fieldType
            + '}';
  }
}
