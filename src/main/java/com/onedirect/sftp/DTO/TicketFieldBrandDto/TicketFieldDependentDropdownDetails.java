package com.onedirect.sftp.DTO.TicketFieldBrandDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketFieldDependentDropdownDetails {

    private Integer id;
    private String value;
    private Map<Long, List<TicketFieldValue>> parentOptionIdToValueMap;
    private Long mapKey;
    private Byte updated;
    private Byte isAutoSelect;

    public TicketFieldDependentDropdownDetails() {
        super();
    }

    public TicketFieldDependentDropdownDetails(Integer id, String value, Map<Long, List<TicketFieldValue>>
            parentOptionIdToValueMap, Long mapKey, Byte updated, Byte isAutoSelect) {
        this.id = id;
        this.value = value;
        this.parentOptionIdToValueMap = parentOptionIdToValueMap;
        this.mapKey = mapKey;
        this.updated = updated;
        this.isAutoSelect = isAutoSelect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Byte getUpdated() {
        return updated;
    }

    public void setUpdated(Byte updated) {
        this.updated = updated;
    }

    public Map<Long, List<TicketFieldValue>> getParentOptionIdToValueMap() {
        return parentOptionIdToValueMap;
    }

    public void setParentOptionIdToValueMap(Map<Long, List<TicketFieldValue>> parentOptionIdToValueMap) {
        this.parentOptionIdToValueMap = parentOptionIdToValueMap;
    }

    public Long getMapKey() {
        return mapKey;
    }

    public void setMapKey(Long mapKey) {
        this.mapKey = mapKey;
    }

    public Byte getAutoSelect() {
        return isAutoSelect;
    }

    public void setAutoSelect(Byte autoSelect) {
        isAutoSelect = autoSelect;
    }

    @Override
    public String toString() {
        return "TicketFieldDependentDropdownDetails{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", parentOptionIdToValueMap=" + parentOptionIdToValueMap +
                ", mapKey=" + mapKey +
                ", updated=" + updated +
                ", isAutoSelect=" + isAutoSelect +
                '}';
    }
}
