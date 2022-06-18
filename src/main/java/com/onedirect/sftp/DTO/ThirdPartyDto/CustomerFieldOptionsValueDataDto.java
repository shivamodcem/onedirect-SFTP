package com.onedirect.sftp.DTO.ThirdPartyDto;

public class CustomerFieldOptionsValueDataDto {

  private Long optionId;
  private Object value;

  public Long getOptionId() {
    return optionId;
  }

  public void setOptionId(Long optionId) {
    this.optionId = optionId;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "CustomerFieldOptionsValueDataDto{"
            + " optionId=" + optionId
            + ", value=" + value
            + '}';
  }
}
