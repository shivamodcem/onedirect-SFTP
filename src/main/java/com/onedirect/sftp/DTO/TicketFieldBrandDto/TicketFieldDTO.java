package com.onedirect.sftp.DTO.TicketFieldBrandDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketFieldDTO {

    private Integer id;
    private Integer brandId;
    private String fieldTitle;
    private Byte fieldType;
    private String fieldDesc;
    private Byte isRuleQualified;
    private Byte status;
    private String apiKey;
    private Integer parentCustomValueId;
    //TODO remove this after eventMappingDto launch
    private List<Byte> eventMapping;
    private List<EventMappingDto> eventMappingDto;
    private List<TicketFieldDependentDropdownDetails> ticketFieldDependentDropdownDetailsList;
    private List<TicketFieldValue> fieldValues;
    private List<TicketFieldRegex> regex;
    private Byte updated;
    private Byte isEditable = (byte) 1;
    private Boolean customerVisibility;

    public TicketFieldDTO() {
        super();
    }

    public TicketFieldDTO(Integer id, Integer brandId, String fieldTitle, Byte fieldType, String
        fieldDesc, Byte isRuleQualified, Byte status, String apiKey, Integer parentCustomValueId,
                          List<Byte> eventMapping, List<TicketFieldDependentDropdownDetails>
                              ticketFieldDependentDropdownDetailsList, List<TicketFieldValue>
                              fieldValues, List<TicketFieldRegex> regex, Byte updated, Byte isEditable,
                          Boolean customerVisibility) {
        this.id = id;
        this.brandId = brandId;
        this.fieldTitle = fieldTitle;
        this.fieldType = fieldType;
        this.fieldDesc = fieldDesc;
        this.isRuleQualified = isRuleQualified;
        this.status = status;
        this.apiKey = apiKey;
        this.parentCustomValueId = parentCustomValueId;
        this.eventMapping = eventMapping;
        this.ticketFieldDependentDropdownDetailsList = ticketFieldDependentDropdownDetailsList;
        this.fieldValues = fieldValues;
        this.regex = regex;
        this.updated = updated;
        this.isEditable = isEditable == null ? (byte) 1 : isEditable;
        this.customerVisibility = customerVisibility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public Byte getFieldType() {
        return fieldType;
    }

    public void setFieldType(Byte fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public Byte getIsRuleQualified() {
        return isRuleQualified;
    }

    public void setIsRuleQualified(Byte isRuleQualified) {
        this.isRuleQualified = isRuleQualified;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Integer getParentCustomValueId() {
        return parentCustomValueId;
    }

    public void setParentCustomValueId(Integer parentCustomValueId) {
        this.parentCustomValueId = parentCustomValueId;
    }

    public List<Byte> getEventMapping() {
        return eventMapping;
    }

    public void setEventMapping(List<Byte> eventMapping) {
        this.eventMapping = eventMapping;
    }

    public List<TicketFieldDependentDropdownDetails> getTicketFieldDependentDropdownDetailsList() {
        return ticketFieldDependentDropdownDetailsList;
    }

    public void setTicketFieldDependentDropdownDetailsList(List<TicketFieldDependentDropdownDetails> ticketFieldDependentDropdownDetailsList) {
        this.ticketFieldDependentDropdownDetailsList = ticketFieldDependentDropdownDetailsList;
    }

    public List<TicketFieldValue> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<TicketFieldValue> fieldValues) {
        this.fieldValues = fieldValues;
    }

    public List<TicketFieldRegex> getRegex() {
        return regex;
    }

    public void setRegex(List<TicketFieldRegex> regex) {
        this.regex = regex;
    }

    public Byte getUpdated() {
        return updated;
    }

    public void setUpdated(Byte updated) {
        this.updated = updated;
    }

    public Byte getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Byte isEditable) {
        this.isEditable = isEditable == null ? (byte) 1 : isEditable;
    }

    public Boolean getCustomerVisibility() {
        return customerVisibility;
    }

    public void setCustomerVisibility(Boolean customerVisibility) {
        this.customerVisibility = customerVisibility;
    }
  
    public List<EventMappingDto> getEventMappingDto() {
        return eventMappingDto;
    }

    public void setEventMappingDto(List<EventMappingDto> eventMappingDto) {
        this.eventMappingDto = eventMappingDto;
    }

    @Override
    public String toString() {
        return "TicketFieldDTO{" +
            "id=" + id +
            ", brandId=" + brandId +
            ", fieldTitle='" + fieldTitle + '\'' +
            ", fieldType=" + fieldType +
            ", fieldDesc='" + fieldDesc + '\'' +
            ", isRuleQualified=" + isRuleQualified +
            ", status=" + status +
            ", apiKey='" + apiKey + '\'' +
            ", parentCustomValueId=" + parentCustomValueId +
            ", eventMapping=" + eventMapping +
            ", eventMappingDto=" + eventMappingDto +
            ", ticketFieldDependentDropdownDetailsList=" + ticketFieldDependentDropdownDetailsList +
            ", fieldValues=" + fieldValues +
            ", regex=" + regex +
            ", updated=" + updated +
            ", isEditable=" + isEditable +
            ", customerVisibility=" + customerVisibility +
            '}';
    }
}
