package com.onedirect.sftp.DTO.ThirdPartyDto;

public class TicketFieldValuesDataDto {
  private Object value;
  private Long optionId;

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public Long getOptionId() {
    return optionId;
  }

  public void setOptionId(Long optionId) {
    this.optionId = optionId;
  }

  @Override
  public String toString() {
    return "TicketFieldValuesDataDto{"
            + "value=" + value
            + ", optionId=" + optionId
            + '}';
  }
}
