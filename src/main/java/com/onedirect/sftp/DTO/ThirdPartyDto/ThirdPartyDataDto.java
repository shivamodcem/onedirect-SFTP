package com.onedirect.sftp.DTO.ThirdPartyDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ThirdPartyDataDto implements Serializable {


  private static final long serialVersionUID = 1L;

  private long id;
  private int brandId;
  private int resourceType;
  private String description;
  private String subject;
  private Float rating;
  private String sourceURL;
  private int createdBy;
  private Date createdAt;


  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
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
   * @return the sourceURL
   */
  public String getSourceURL() {
    return sourceURL;
  }

  /**
   * @param sourceURL the sourceURL to set
   */
  public void setSourceURL(String sourceURL) {
    this.sourceURL = sourceURL;
  }

  /**
   * @return the createdBy
   */
  public int getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
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

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ThirdPartyDataDto [id=").append(id).append(", brandId=").append(brandId)
            .append(", source=").append(resourceType).append(", description=").append(description)
            .append(", subject=").append(subject).append(", rating=").append(rating)
            .append(", sourceURL=").append(sourceURL).append(", createdBy=").append(createdBy)
            .append(", createdAt=").append(createdAt).append("]");
    return builder.toString();
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


}
