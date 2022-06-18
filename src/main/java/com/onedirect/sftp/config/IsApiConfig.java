package com.onedirect.sftp.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "isapi")
public class IsApiConfig {
    private String url;

    private Integer brandId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getBrandId() {
        return brandId;
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
        return "IsApiServiceConfig{" +
                "url='" + url + '\'' +
                ", brandId=" + brandId +
                ", brandUserId=" + brandUserId +
                ", ProductId=" + productId +
                '}';
    }
}
