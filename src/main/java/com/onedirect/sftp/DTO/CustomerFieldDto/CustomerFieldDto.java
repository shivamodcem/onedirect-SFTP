package com.onedirect.sftp.DTO.CustomerFieldDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onedirect.dtocommons.dto.FieldMaskingDto;


import java.util.Date;
import java.util.List;
import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerFieldDto {

  private Integer id;
  private String fieldTitle;
  private String fieldDescription;
  private String apiKey;
  private byte fieldType;
  private String fieldTypeName;
  private Date updatedAt;
  private Integer updatedBy;
  private Integer createdBy;
  private Integer parentCustomValueId;
  private List<CustomerFieldOptionDto> fieldValues;
  private List<CustomerFieldRegexDto> regex;
  private CustomerFieldDto alternateField;
  private Byte updated;
  private boolean hasAlternate;
  private boolean isPrimary;
  private Byte primaryType;
  private boolean isDefault;
  private Integer displayOrder;
  private Byte defaultType;
  private Byte onBoard;
  private Map<Byte, Boolean> visibilityMap;
  private Byte productId;
  private FieldMaskingDto fieldMaskingDto;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFieldTitle() {
    return fieldTitle;
  }

  public void setFieldTitle(String fieldTitle) {
    this.fieldTitle = fieldTitle;
  }

  public byte getFieldType() {
    return fieldType;
  }

  public void setFieldType(byte fieldType) {
    this.fieldType = fieldType;
  }

  public String getFieldTypeName() {
    return fieldTypeName;
  }

  public void setFieldTypeName(String fieldTypeName) {
    this.fieldTypeName = fieldTypeName;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Integer getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Integer updatedBy) {
    this.updatedBy = updatedBy;
  }

  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  public Integer getParentCustomValueId() {
    return parentCustomValueId;
  }

  public void setParentCustomValueId(Integer parentCustomValueId) {
    this.parentCustomValueId = parentCustomValueId;
  }

  public List<CustomerFieldOptionDto> getFieldValues() {
    return fieldValues;
  }

  public void setFieldValues(List<CustomerFieldOptionDto> fieldValues) {
    this.fieldValues = fieldValues;
  }

  public List<CustomerFieldRegexDto> getRegex() {
    return regex;
  }

  public void setRegex(List<CustomerFieldRegexDto> regex) {
    this.regex = regex;
  }

  public Byte getUpdated() {
    return updated;
  }

  public void setUpdated(Byte updated) {
    this.updated = updated;
  }

  public boolean isHasAlternate() {
    return hasAlternate;
  }

  public void setHasAlternate(boolean hasAlternate) {
    this.hasAlternate = hasAlternate;
  }

  public boolean getIsPrimary() {
    return isPrimary;
  }

  public void setPrimary(boolean primary) {
    isPrimary = primary;
  }

  public Byte getPrimaryType() {
    return primaryType;
  }

  public void setPrimaryType(Byte primaryType) {
    this.primaryType = primaryType;
  }

  public boolean getIsDefault() {
    return isDefault;
  }

  public void setDefault(boolean aDefault) {
    isDefault = aDefault;
  }

  public CustomerFieldDto getAlternateField() {
    return alternateField;
  }

  public void setAlternateField(CustomerFieldDto alternateField) {
    this.alternateField = alternateField;
  }

  public boolean isDefault() {
    return isDefault;
  }

  public Byte getDefaultType() {
    return defaultType;
  }

  public void setDefaultType(Byte defaultType) {
    this.defaultType = defaultType;
  }

  public Map<Byte, Boolean> getVisibilityMap() {
    return visibilityMap;
  }

  public void setVisibilityMap(Map<Byte, Boolean> visibilityMap) {
    this.visibilityMap = visibilityMap;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public Byte getOnBoard() {
    return onBoard;
  }

  public void setOnBoard(Byte onBoard) {
    this.onBoard = onBoard;
  }

  public String getFieldDescription() {
    return fieldDescription;
  }

  public void setFieldDescription(String fieldDescription) {
    this.fieldDescription = fieldDescription;
  }


  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getApiKey() {
    return apiKey;
  }

  public Byte getProductId() { return productId; }

  public void setProductId(Byte productId) { this.productId = productId; }

  public FieldMaskingDto getFieldMaskingDto() { return fieldMaskingDto; }

  public void setFieldMaskingDto(FieldMaskingDto fieldMaskingDto) { this.fieldMaskingDto = fieldMaskingDto; }

  @Override
  public String toString() {
    return "CustomerFieldDto{" +
        "id=" + id +
        ", fieldTitle='" + fieldTitle + '\'' +
        ", fieldType=" + fieldType +
        ", fieldTypeName='" + fieldTypeName + '\'' +
        ", updatedAt=" + updatedAt +
        ", updatedBy=" + updatedBy +
        ", createdBy=" + createdBy +
        ", parentCustomValueId=" + parentCustomValueId +
        ", fieldValues=" + fieldValues +
        ", regex=" + regex +
        ", alternateField=" + alternateField +
        ", updated=" + updated +
        ", hasAlternate=" + hasAlternate +
        ", isPrimary=" + isPrimary +
        ", primaryType=" + primaryType +
        ", isDefault=" + isDefault +
        ", fieldDescription=" + fieldDescription +

        '}';
  }
}
