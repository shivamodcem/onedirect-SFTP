package com.onedirect.sftp.DTO.CustomerFieldDto;

public class CustomerFieldRegexDto {

  private Integer id;
  private Integer operator;
  private String expression;
  private String errorMsg;
  private Byte updated;

  public Integer getId() {
    return id;
  }

  public Integer getOperator() {
    return operator;
  }

  public void setOperator(Integer operator) {
    this.operator = operator;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public Byte getUpdated() {
    return updated;
  }

  public void setUpdated(Byte updated) {
    this.updated = updated;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
