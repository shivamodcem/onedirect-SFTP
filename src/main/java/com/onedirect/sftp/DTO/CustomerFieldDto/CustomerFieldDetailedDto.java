package com.onedirect.sftp.DTO.CustomerFieldDto;

import com.onedirect.dtocommons.dto.v2.CustomerAddressDto;

import java.util.List;

public class CustomerFieldDetailedDto {

  private List<CustomerFieldDto> customerFields;
  private CustomerAddressDto customerAddress;

  public List<CustomerFieldDto> getCustomerFields() {
    return customerFields;
  }

  public void setCustomerFields(List<CustomerFieldDto> customerFields) {
    this.customerFields = customerFields;
  }

  public CustomerAddressDto getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(CustomerAddressDto customerAddress) {
    this.customerAddress = customerAddress;
  }

  @Override
  public String toString() {
    return "CustomerFieldDTo{" +
            "customerFields=" + customerFields.toString() +
            ", CustomerAddressDto='" + customerAddress.toString() + '\'' +
            '}';
  }
}
