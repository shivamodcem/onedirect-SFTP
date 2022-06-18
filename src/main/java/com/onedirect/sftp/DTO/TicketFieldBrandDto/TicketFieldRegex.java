package com.onedirect.sftp.DTO.TicketFieldBrandDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketFieldRegex {

    private Integer id;
    private Integer operator;
    private String expression;
    private String errorMsg;
    private Byte updated;

    public TicketFieldRegex() {
        super();
    }

    public TicketFieldRegex(Integer id, Integer operator, String expression, String errorMsg, Byte updated) {
        this.id = id;
        this.operator = operator;
        this.expression = expression;
        this.errorMsg = errorMsg;
        this.updated = updated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "TicketFieldRegex{" +
                "operator=" + operator +
                ", expression='" + expression + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", updated=" + updated +
                '}';
    }
}
