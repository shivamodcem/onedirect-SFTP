package com.onedirect.sftp.DTO.ThirdPartyDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onedirect.sftp.DTO.FileData;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ThirdPartyTicketInputDto implements Serializable {

  private static final long serialVersionUID = 1L;

//  public ThirdPartyTicketInputDto(String name,String description,Integer resourceType,Integer assignedTo,Integer
//                                  teamId,List<TicketFieldDto> ticketFields,Integer ticketFormId, Integer ticketFormType
//                                  )
//  {
//    this.name=name;
//    this.description=description;
//    this.resourceType=resourceType;
//    this.assignedTo=assignedTo;
//    this.teamId=teamId;
//    this.ticketFields=ticketFields;
//    this.ticketFormType=ticketFormType;
//  }
  // custom info
  private String name;
  private String primaryMobile;
  private String primaryEmail;
  private String alternateMobile;
  private String customerProfileInfo;

  private List<CustomerFieldRequestDto> customerField;

  // company info
  private int brandId;
  private int updatedBy;
  private Integer assignedTo;
  private Integer currentlyAssignedTo;

  // ticket info
  private int resourceType;
  private String description;
  private String subject;
  private Byte isEditable;
  private Float rating;
  private String sourceURL;
  private String attachmentURL;
  private List<MultipartFile> files;

  private byte priority;
  private List<Integer> tags;
  private Set<Integer> customerTags;
  private HashMap<Integer, String> customInfo;

  private List<Map<Integer,String>> customInfoList;
  private String customInfoListString;
  private List<TicketFieldDto> ticketFields;

  private String customerAddList;
  private Integer teamId;

  private String customerProfileUrl;

  // This value defines from which source, we are getting api request
  private Byte apiRequestSource;

  //apply ticket rules.
  private boolean applyTicketRules;

  private List<FileData> filesData;

  // Feedback cloud ticket data
  private List<String> tagNames;
  private String uuid;
  private Long resourcePublishDate;


  //Ticket Form Data
  private Integer ticketFormId;
  private Integer ticketFormType;


  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the primaryMobile
   */
  public String getPrimaryMobile() {
    return primaryMobile;
  }

  /**
   * @param primaryMobile the primaryMobile to set
   */
  public void setPrimaryMobile(String primaryMobile) {
    this.primaryMobile = primaryMobile;
  }

  /**
   * @return the primaryEmail
   */
  public String getPrimaryEmail() {
    return primaryEmail;
  }

  /**
   * @param primaryEmail the primaryEmail to set
   */
  public void setPrimaryEmail(String primaryEmail) {
    this.primaryEmail = primaryEmail;
  }

  /**
   * @return the customerProfileInfo
   */
  public String getCustomerProfileInfo() {
    return customerProfileInfo;
  }

  /**
   * @param customerProfileInfo the customerProfileInfo to set
   */
  public void setCustomerProfileInfo(String customerProfileInfo) {
    this.customerProfileInfo = customerProfileInfo;
  }

  /**
   * @return the brandId
   */
  public int getBrandId() {
    return brandId;
  }

  /**
   * @param brandId the brandId to set
   */
  public void setBrandId(int brandId) {
    this.brandId = brandId;
  }

  /**
   * @return the updatedBy
   */
  public int getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy the updatedBy to set
   */
  public void setUpdatedBy(int updatedBy) {
    this.updatedBy = updatedBy;
  }

  /**
   * @return the resourceType
   */
  public int getResourceType() {
    return resourceType;
  }

  /**
   * @param resourceType the resourceType to set
   */
  public void setResourceType(int resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * @param subject the subject to set
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * @return the sourceURL
   */
  public String getSourceURL() {
    return sourceURL;
  }

  /**
   * @paramsourceUrl the sourceURL to set
   */
  public void setSourceURL(String sourceURL) {
    if (sourceURL != null && (sourceURL.startsWith("http://") || sourceURL.startsWith("https://"))) {
      this.sourceURL = sourceURL;
    } else if (sourceURL != null && !sourceURL.isEmpty()) {
      this.sourceURL = "http://" + sourceURL;
    }
  }

  /**
   * @return the attachmentURL
   */
  public String getAttachmentURL() {
    return attachmentURL;
  }

  /**
   * @paramattachmentUrl the attachmentURL to set
   */
  public void setAttachmentURL(String attachmentURL) {
    this.attachmentURL = attachmentURL;
  }

  /**
   * @return the priority
   */
  public byte getPriority() {
    return priority;
  }

  /**
   * @param priority the priority to set
   */
  public void setPriority(byte priority) {
    this.priority = priority;
  }

  /**
   * @return the tags
   */
  public List<Integer> getTags() {
    return tags;
  }

  /**
   * @param tags the tags to set
   */
  public void setTags(List<Integer> tags) {
    this.tags = tags;
  }

  /**
   * @return the customInfo
   */
  public HashMap<Integer, String> getCustomInfo() {
    return customInfo;
  }

  /**
   * @param customInfo the customInfo to set
   */
  public void setCustomInfo(HashMap<Integer, String> customInfo) {
    this.customInfo = customInfo;
  }
  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */

  /**
   * @return the files
   */
  public List<MultipartFile> getFiles() {
    return files;
  }

  /**
   * @param files the files to set
   */
  public void setFiles(List<MultipartFile> files) {
    this.files = files;
  }

  public Integer getTeamId() {
    return teamId;
  }

  public void setTeamId(Integer teamId) {
    this.teamId = teamId;
  }

  /**
   * @return the assignedTo
   */
  public Integer getAssignedTo() {
    return assignedTo;
  }

  /**
   * @param assignedTo the assignedTo to set
   */
  public void setAssignedTo(Integer assignedTo) {
    this.assignedTo = assignedTo;
  }

  /**
   * @return the rating
   */
  public Float getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(Float rating) {
    this.rating = rating;
  }

  /**
   * @return the customerAddList
   */
  public String getCustomerAddList() {
    return customerAddList;
  }

  /**
   * @param customerAddList the customerAddList to set
   */
  public void setCustomerAddList(String customerAddList) {
    this.customerAddList = customerAddList;
  }

  public Integer getCurrentlyAssignedTo() {
    return currentlyAssignedTo;
  }

  public void setCurrentlyAssignedTo(Integer currentlyAssignedTo) {
    this.currentlyAssignedTo = currentlyAssignedTo;
  }

  public String getCustomerProfileUrl() {
    return customerProfileUrl;
  }

  public void setCustomerProfileUrl(String customerProfileUrl) {
    this.customerProfileUrl = customerProfileUrl;
  }

  public Byte getApiRequestSource() {
    return apiRequestSource;
  }

  public void setApiRequestSource(Byte apiRequestSource) {
    this.apiRequestSource = apiRequestSource;
  }

  public boolean isApplyTicketRules() {
    return applyTicketRules;
  }

  public void setApplyTicketRules(boolean applyTicketRules) {
    this.applyTicketRules = applyTicketRules;
  }

  public List<Map<Integer, String>> getCustomInfoList() {
    return customInfoList;
  }

  public void setCustomInfoList(
      List<Map<Integer, String>> customInfoList) {
    this.customInfoList = customInfoList;
  }

  public String getCustomInfoListString() {
    return customInfoListString;
  }

  public void setCustomInfoListString(String customInfoListString) {
    this.customInfoListString = customInfoListString;
  }

  public String getAlternateMobile() {
    return alternateMobile;
  }

  public void setAlternateMobile(String alternateMobile) {
    this.alternateMobile = alternateMobile;
  }

  public List<TicketFieldDto> getTicketFields() {
    return ticketFields;
  }

  public void setTicketFields(List<TicketFieldDto> ticketFields) {
    this.ticketFields = ticketFields;
  }

  public List<String> getTagNames() {
    return tagNames;
  }

  public void setTagNames(List<String> tagNames) {
    this.tagNames = tagNames;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Long getResourcePublishDate() {
    return resourcePublishDate;
  }

  public void setResourcePublishDate(Long resourcePublishDate) {
    this.resourcePublishDate = resourcePublishDate;
  }

  public List<FileData> getFilesData() {
    return filesData;
  }

  public void setFilesData(List<FileData> filesData) {
    this.filesData = filesData;
  }

  public List<CustomerFieldRequestDto> getCustomerField() {
    return customerField;
  }

  public void setCustomerField(List<CustomerFieldRequestDto> customerField) {
    this.customerField = customerField;
  }

  public Integer getTicketFormId() {
    return ticketFormId;
  }

  public void setTicketFormId(Integer ticketFormId) {
    this.ticketFormId = ticketFormId;
  }

  public Byte getIsEditable() {
    return isEditable;
  }

  public void setIsEditable(Byte isEditable) {
    this.isEditable = isEditable;

  }

  public Integer getTicketFormType() {
    return ticketFormType;
  }

  public void setTicketFormType(Integer ticketFormType) {
    this.ticketFormType = ticketFormType;
  }

  public Set<Integer> getCustomerTags() {
    return customerTags;
  }

  public void setCustomerTags(Set<Integer> customerTags) {
    this.customerTags = customerTags;
  }

  @Override
  public String toString() {
    return "ThirdPartyTicketInputDto{"
            + "name='" + name + '\''
            + ", primaryMobile='" + primaryMobile + '\''
            + ", primaryEmail='" + primaryEmail + '\''
            + ", alternateMobile='" + alternateMobile + '\''
            + ", customerProfileInfo='" + customerProfileInfo + '\''
            + ", customerField='" + customerField + '\''
            + ", brandId=" + brandId
            + ", updatedBy=" + updatedBy
            + ", assignedTo=" + assignedTo
            + ", currentlyAssignedTo=" + currentlyAssignedTo
            + ", resourceType=" + resourceType
            + ", description='" + description + '\''
            + ", subject='" + subject + '\''
            + ", isEditable=" + isEditable
            + ", rating=" + rating
            + ", sourceURL='" + sourceURL + '\''
            + ", attachmentURL='" + attachmentURL + '\''
            + ", files=" + files
            + ", priority=" + priority
            + ", tags=" + tags
            + ", customInfo=" + customInfo
            + ", customInfoList=" + customInfoList
            + ", customInfoListString='" + customInfoListString + '\''
            + ", ticketFields='" + ticketFields + '\''
            + ", customerAddList='" + customerAddList + '\''
            + ", teamId=" + teamId
            + ", customerProfileUrl='" + customerProfileUrl + '\''
            + ", apiRequestSource=" + apiRequestSource
            + ", applyTicketRules=" + applyTicketRules
            + ", filesData=" + filesData
            + ", tagNames=" + tagNames
            + ", uuid='" + uuid + '\''
            + ", resourcePublishDate=" + resourcePublishDate
            + ", ticketFormId=" + ticketFormId
            + ", ticketFormType=" + ticketFormType
            + '}';
  }
}