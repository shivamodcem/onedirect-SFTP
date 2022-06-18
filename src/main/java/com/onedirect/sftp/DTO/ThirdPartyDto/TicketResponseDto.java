package com.onedirect.sftp.DTO.ThirdPartyDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketResponseDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private static final Gson gson = new GsonBuilder().serializeNulls().create();

  private Long id;

  private Long customerId;

  private Integer brandId;

  private Long brandTicketId;

  private Byte source;

  private Byte currentStatus;

  private Byte currentPriority;

  private int subSource;

  private Byte ticketType;

  private String ticketUrl;

  private Date firstAssignmentDate;

  private Date currentAssignmentDate;

  private Integer currentlyAssignedTo;

  private Date firstBrandResponseDate;

  private Date latestBrandResponseDate;

  private Date dueDate;

  private Date latestCustomerResponseDate;

  private Byte currentSentiment;

  private Byte slaBreachStatus;

  private Byte isActionable;

  private Date createdAt;

  private Integer createdBy;

  private Byte updatedByType;

  private Integer customerReplyCount;

  private Integer brandReplyCount;

  private List<Integer> tagList;

  private Integer teamId;

  private boolean alwaysCreateNewTicket;

  private Byte associationType;

  private Byte status;

  private ThirdPartyDataDto data;


  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the customerId
   */
  public Long getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId the customerId to set
   */
  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  /**
   * @return the brandId
   */
  public Integer getBrandId() {
    return brandId;
  }

  /**
   * @param brandId the brandId to set
   */
  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }

  /**
   * @return the brandTicketId
   */
  public Long getBrandTicketId() {
    return brandTicketId;
  }

  /**
   * @param brandTicketId the brandTicketId to set
   */
  public void setBrandTicketId(Long brandTicketId) {
    this.brandTicketId = brandTicketId;
  }

  /**
   * @return the source
   */
  public Byte getSource() {
    return source;
  }

  /**
   * @param source the source to set
   */
  public void setSource(Byte source) {
    this.source = source;
  }

  /**
   * @return the currentStatus
   */
  public Byte getCurrentStatus() {
    return currentStatus;
  }

  /**
   * @param currentStatus the currentStatus to set
   */
  public void setCurrentStatus(Byte currentStatus) {
    this.currentStatus = currentStatus;
  }

  /**
   * @return the currentPriority
   */
  public Byte getCurrentPriority() {
    return currentPriority;
  }

  /**
   * @param currentPriority the currentPriority to set
   */
  public void setCurrentPriority(Byte currentPriority) {
    this.currentPriority = currentPriority;
  }

  /**
   * @return the ticketType
   */
  public Byte getTicketType() {
    return ticketType;
  }

  /**
   * @param ticketType the ticketType to set
   */
  public void setTicketType(Byte ticketType) {
    this.ticketType = ticketType;
  }

  /**
   * @return the ticketUrl
   */
  public String getTicketUrl() {
    return ticketUrl;
  }

  /**
   * @param ticketUrl the ticketUrl to set
   */
  public void setTicketUrl(String ticketUrl) {
    this.ticketUrl = ticketUrl;
  }

  /**
   * @return the firstAssignmentDate
   */
  public Date getFirstAssignmentDate() {
    return firstAssignmentDate;
  }

  /**
   * @param firstAssignmentDate the firstAssignmentDate to set
   */
  public void setFirstAssignmentDate(Date firstAssignmentDate) {
    this.firstAssignmentDate = firstAssignmentDate;
  }

  /**
   * @return the currentAssignmentDate
   */
  public Date getCurrentAssignmentDate() {
    return currentAssignmentDate;
  }

  /**
   * @param currentAssignmentDate the currentAssignmentDate to set
   */
  public void setCurrentAssignmentDate(Date currentAssignmentDate) {
    this.currentAssignmentDate = currentAssignmentDate;
  }

  /**
   * @return the currentlyAssignedTo
   */
  public Integer getCurrentlyAssignedTo() {
    return currentlyAssignedTo;
  }

  /**
   * @param currentlyAssignedTo the currentlyAssignedTo to set
   */
  public void setCurrentlyAssignedTo(Integer currentlyAssignedTo) {
    this.currentlyAssignedTo = currentlyAssignedTo;
  }

  /**
   * @return the firstBrandResponseDate
   */
  public Date getFirstBrandResponseDate() {
    return firstBrandResponseDate;
  }

  /**
   * @param firstBrandResponseDate the firstBrandResponseDate to set
   */
  public void setFirstBrandResponseDate(Date firstBrandResponseDate) {
    this.firstBrandResponseDate = firstBrandResponseDate;
  }

  /**
   * @return the latestBrandResponseDate
   */
  public Date getLatestBrandResponseDate() {
    return latestBrandResponseDate;
  }

  /**
   * @param latestBrandResponseDate the latestBrandResponseDate to set
   */
  public void setLatestBrandResponseDate(Date latestBrandResponseDate) {
    this.latestBrandResponseDate = latestBrandResponseDate;
  }

  /**
   * @return the dueDate
   */
  public Date getDueDate() {
    return dueDate;
  }

  /**
   * @param dueDate the dueDate to set
   */
  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  /**
   * @return the latestCustomerResponseDate
   */
  public Date getLatestCustomerResponseDate() {
    return latestCustomerResponseDate;
  }

  /**
   * @param latestCustomerResponseDate the latestCustomerResponseDate to set
   */
  public void setLatestCustomerResponseDate(Date latestCustomerResponseDate) {
    this.latestCustomerResponseDate = latestCustomerResponseDate;
  }

  /**
   * @return the currentSentiment
   */
  public Byte getCurrentSentiment() {
    return currentSentiment;
  }

  /**
   * @param currentSentiment the currentSentiment to set
   */
  public void setCurrentSentiment(Byte currentSentiment) {
    this.currentSentiment = currentSentiment;
  }

  /**
   * @return the slaBreachStatus
   */
  public Byte getSlaBreachStatus() {
    return slaBreachStatus;
  }

  /**
   * @param slaBreachStatus the slaBreachStatus to set
   */
  public void setSlaBreachStatus(Byte slaBreachStatus) {
    this.slaBreachStatus = slaBreachStatus;
  }

  /**
   * @return the isActionable
   */
  public Byte getIsActionable() {
    return isActionable;
  }

  /**
   * @param isActionable the isActionable to set
   */
  public void setIsActionable(Byte isActionable) {
    this.isActionable = isActionable;
  }

  /**
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the createdBy
   */
  public Integer getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the updatedByType
   */
  public Byte getUpdatedByType() {
    return updatedByType;
  }

  /**
   * @param updatedByType the updatedByType to set
   */
  public void setUpdatedByType(Byte updatedByType) {
    this.updatedByType = updatedByType;
  }

  /**
   * @return the customerReplyCount
   */
  public Integer getCustomerReplyCount() {
    return customerReplyCount;
  }

  /**
   * @param customerReplyCount the customerReplyCount to set
   */
  public void setCustomerReplyCount(Integer customerReplyCount) {
    this.customerReplyCount = customerReplyCount;
  }

  /**
   * @return the brandReplyCount
   */
  public Integer getBrandReplyCount() {
    return brandReplyCount;
  }

  /**
   * @param brandReplyCount the brandReplyCount to set
   */
  public void setBrandReplyCount(Integer brandReplyCount) {
    this.brandReplyCount = brandReplyCount;
  }

  /**
   * @return the tagList
   */
  public List<Integer> getTagList() {
    return tagList;
  }

  /**
   * @param tagList the tagList to set
   */
  public void setTagList(List<Integer> tagList) {
    this.tagList = tagList;
  }

  /**
   * @return the subSource
   */
  public int getSubSource() {
    return subSource;
  }

  /**
   * @param subSource the subSource to set
   */
  public void setSubSource(int subSource) {
    this.subSource = subSource;
  }

  public Integer getTeamId() {
    return teamId;
  }

  public void setTeamId(Integer teamId) {
    this.teamId = teamId;
  }

  public boolean isAlwaysCreateNewTicket() {
    return alwaysCreateNewTicket;
  }

  public void setAlwaysCreateNewTicket(boolean alwaysCreateNewTicket) {
    this.alwaysCreateNewTicket = alwaysCreateNewTicket;
  }

  public Byte getStatus() {
    return status;
  }

  public void setStatus(Byte status) {
    this.status = status;
  }

  public Byte getAssociationType() {
    return associationType;
  }

  public void setAssociationType(Byte associationType) {
    this.associationType = associationType;
  }

  public ThirdPartyDataDto getData() {
    return data;
  }

  public void setData(ThirdPartyDataDto data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return gson.toJson(this);
  }
}
