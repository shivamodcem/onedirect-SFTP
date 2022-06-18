package com.onedirect.sftp.DTO.ThirdPartyDto;

public class CustomerFieldOptionsValueDataDto {
  private Integer mappingId;
  private Long optionId;
  private Object value;

  public Integer getMappingId() {
    return mappingId;
  }

  public void setMappingId(Integer mappingId) {
    this.mappingId = mappingId;
  }

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
            + "mappingId=" + mappingId
            + ", optionId=" + optionId
            + ", value=" + value
            + '}';
  }
}
