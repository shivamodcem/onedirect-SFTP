package com.onedirect.sftp.DTO.CustomerFieldDto;

import java.util.List;

public class CustomerFieldOptionDto {

  private Long id;
  private String value;
  private Integer customerFieldId;
  private List<CustomerFieldOptionDto> nextLevel;
  private Byte updated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getCustomerFieldId() {
    return customerFieldId;
  }

  public void setCustomerFieldId(Integer ticketFieldId) {
    this.customerFieldId = ticketFieldId;
  }

  public List<CustomerFieldOptionDto> getNextLevel() {
    return nextLevel;
  }

  public void setNextLevel(List<CustomerFieldOptionDto> nextLevel) {
    this.nextLevel = nextLevel;
  }

  public Byte getUpdated() {
    return updated;
  }

  public void setUpdated(Byte updated) {
    this.updated = updated;
  }

}
