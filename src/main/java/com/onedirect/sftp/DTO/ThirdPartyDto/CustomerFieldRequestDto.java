package com.onedirect.sftp.DTO.ThirdPartyDto;

import java.util.List;

public class CustomerFieldRequestDto {

  private Long id;
  private Integer fieldId;
  private List<CustomerFieldOptionsValueDataDto> fieldValuesDataList;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getFieldId() {
    return fieldId;
  }

  public void setFieldId(Integer fieldId) {
    this.fieldId = fieldId;
  }

  public List<CustomerFieldOptionsValueDataDto> getFieldValuesDataList() {
    return fieldValuesDataList;
  }

  public void setFieldValuesDataList(
          List<CustomerFieldOptionsValueDataDto> fieldValuesDataList) {
    this.fieldValuesDataList = fieldValuesDataList;
  }

  @Override
  public String toString() {
    return "CustomerFieldRequestDto{"
            + "id=" + id
            + ", fieldId=" + fieldId
            + ", fieldValuesDataList=" + fieldValuesDataList
            + '}';
  }
}
