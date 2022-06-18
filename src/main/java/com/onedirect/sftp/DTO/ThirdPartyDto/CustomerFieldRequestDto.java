package com.onedirect.sftp.DTO.ThirdPartyDto;

import java.util.List;

public class CustomerFieldRequestDto {

  private Integer fieldId;
  private List<CustomerFieldOptionsValueDataDto> fieldValuesDataList;



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

            + "fieldId=" + fieldId
            + ", fieldValuesDataList=" + fieldValuesDataList
            + '}';
  }
}
