package com.onedirect.sftp.service;

import com.onedirect.sftp.DTO.BrandUserDto.BrandUserDto;
import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDetailedDto;
import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDto;

import java.util.HashMap;
import java.util.List;

public interface ExtractCustomerField {
    CustomerFieldDetailedDto getCustomerField();

    HashMap<String, CustomerFieldDto> ObjectToMap(CustomerFieldDetailedDto customerFieldDetailedDto);
}
