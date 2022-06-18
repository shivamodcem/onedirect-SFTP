package com.onedirect.sftp.DTO.TicketFieldBrandDto;

import java.util.List;

public class TicketFieldValue {

    private Long id;
    private String value;
    private Byte isDefault;
    private Long parentFieldValueId;
    private Integer ticketFieldId;
    private List<TicketFieldValue> nextLevel;
    private Byte updated;

    public TicketFieldValue() {
        super();
    }

    public TicketFieldValue(Long id, String value, Byte isDefault, Long parentFieldValueId, Integer ticketFieldId, List<TicketFieldValue> nextLevel) {
        this.id = id;
        this.value = value;
        this.isDefault = isDefault;
        this.parentFieldValueId = parentFieldValueId;
        this.ticketFieldId = ticketFieldId;
        this.nextLevel = nextLevel;
    }

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

    public Byte getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Byte isDefault) {
        this.isDefault = isDefault;
    }

    public Long getParentFieldValueId() {
        return parentFieldValueId;
    }

    public void setParentFieldValueId(Long parentFieldValueId) {
        this.parentFieldValueId = parentFieldValueId;
    }

    public Integer getTicketFieldId() {
        return ticketFieldId;
    }

    public void setTicketFieldId(Integer ticketFieldId) {
        this.ticketFieldId = ticketFieldId;
    }

    public Byte getUpdated() {
        return updated;
    }

    public void setUpdated(Byte updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "TicketFieldValue{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", isDefault=" + isDefault +
                ", parentFieldValueId=" + parentFieldValueId +
                ", ticketFieldId=" + ticketFieldId +
                ", nextLevel=" + nextLevel +
                ", updated=" + updated +
                '}';
    }

    public List<TicketFieldValue> getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(List<TicketFieldValue> nextLevel) {
        this.nextLevel = nextLevel;
    }

    public TicketFieldValue getObjectClone(TicketFieldValue tfv) {
        TicketFieldValue ticketFieldValue = new TicketFieldValue();
        ticketFieldValue.setId(tfv.getId());
        ticketFieldValue.setValue(tfv.getValue());
        ticketFieldValue.setTicketFieldId(tfv.getTicketFieldId());
        ticketFieldValue.setIsDefault(tfv.getIsDefault());
        ticketFieldValue.setParentFieldValueId(tfv.getParentFieldValueId());
        ticketFieldValue.setUpdated(tfv.getUpdated());
        return ticketFieldValue;
    }
}
