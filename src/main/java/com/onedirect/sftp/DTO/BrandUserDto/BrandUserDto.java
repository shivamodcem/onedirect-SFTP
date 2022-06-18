package com.onedirect.sftp.DTO.BrandUserDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandUserDto {

    private Integer id;
    private String name;
    private Byte status;

    private String email;

    public BrandUserDto()
    {
        super();
    }

    public BrandUserDto(Integer id, String name, Byte status,String email) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.email=email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "BrandUserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", email=" + email +
                '}';
    }
}
