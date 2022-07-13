package com.onedirect.sftp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "intercomm")
public class InterCommConfig {

    private Integer brandId;
    private String fileName;
    private Integer brandUserId;

    private Byte productId;

    public Byte getProductId()
    {
        return productId;
    }
    public void setProductId(Byte productId)
    {
        this.productId=productId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getBrandUserId() {
        return brandUserId;
    }

    public void setBrandUserId(Integer brandUserId) {
        this.brandUserId = brandUserId;
    }

    @Override
    public String toString() {
        return "InterServiceConfig{" +
                ", brandId=" + brandId +
                ", brandUserId=" + brandUserId +
                ", ProductId=" + productId +
                ", fileName=" + fileName +
                '}';
    }
}
