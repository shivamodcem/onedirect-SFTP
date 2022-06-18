package com.onedirect.sftp.service;

import com.onedirect.sftp.DTO.BrandUserDto.BrandUserDto;

import java.util.HashMap;
import java.util.List;

public interface ExtractBrandUsers {
    List<BrandUserDto> getTotalUsers();
    HashMap<String, Integer> ObjectToMap(List<BrandUserDto> brandUserDtoList);
}
