package com.onedirect.sftp.enums;

import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.CustomerFieldOptionsValueDataDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.CustomerFieldRequestDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.TicketFieldDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.TicketFieldValuesDataDto;
import com.onedirect.sftp.DTO.TicketFieldBrandDto.TicketFieldDTO;
import com.onedirect.sftp.util.brandMappers.ShopperStopHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public enum BrandEnums {

    ShopperStop(6221) {
        @Override
        public Boolean validateMandadtoryFields(HashMap dto, HashMap<String, Integer> brandUserDtoMap)
        {
            if(!validateDescription(dto))
            {
                log.error("Description not found for dto {}",dto);
            }
            if(!validateName(dto))
            {
                log.error("Name not found for dto {}",dto);
            }
            if(!validatePsAssigned(dto,brandUserDtoMap))
            {
                log.error("Ps Agent email not found for dto in isApi {}",dto);
            }
            return true;
        }

        @Override
        public MultiValueMap<String, Object> createThirdpartyInputDto(HashMap<String, String> dto, HashMap<String, Integer> brandUserDtoMap, HashMap<String, CustomerFieldDto> customerFieldDtomap, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap) {
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            List<CustomerFieldRequestDto> customerFieldDtoList=new ArrayList<>();
            List<TicketFieldDto> ticketFieldDtos=new ArrayList<>();
            getAllFieldsPopulated(dto,ticketFieldDtos,customerFieldDtoList,customerFieldDtomap,ticketFieldDtoHashMap);
            String name=getNameForShopper(dto);
            map.add("name",name);
            map.add("description",dto.get("Description"));
            map.add("assignedTo",brandUserDtoMap.get(dto.get("Agent assigned email")));
            map.add("ticketFields",ticketFieldDtos);
            map.add("customerField",customerFieldDtoList);
            map.add("resourceType",0);
            map.add("tags",ShopperStopHelper.getTag());
//        map.add("applyTicketRules", true);
            return map;
        }
    };



    private static String getNameForShopper(HashMap<String, String> dto) {
        if(dto.get("Card Name")!=null)
        {
            return dto.get("Card Name");
        }
        else
        {
            String name="";
            if(dto.get("First Name")!=null)name+=dto.get("First Name");
            if(dto.get("Last Name")!=null)name+=dto.get("Last Name");
            return name;
        }
    }

    public void getAllFieldsPopulated(HashMap<String, String> dto, List<TicketFieldDto> ticketFieldDtos, List<CustomerFieldRequestDto> customerFieldDtoList, HashMap<String, CustomerFieldDto> customerFieldDtomap, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap) {
        HashMap<String,Integer> shopperfieldMap= ShopperStopHelper.getFieldMapping();
        for(Map.Entry<String, String> pair : dto.entrySet())
        {
            if(shopperfieldMap.get(pair.getKey())==null)continue;

            if(shopperfieldMap.get(pair.getKey())==0) //TicketField is 0
            {
                populuateTicketFieldsMapping(pair,ticketFieldDtos,ticketFieldDtoHashMap);
            }
            else if(shopperfieldMap.get(pair.getKey())==1) //TicketField is 1
            {
                populateCustomerFieldsMapping(pair,customerFieldDtoList,customerFieldDtomap);
            }
        }
    }
    private static void populateCustomerFieldsMapping(Map.Entry<String, String> pair, List<CustomerFieldRequestDto> customerFieldDtoList, HashMap<String, CustomerFieldDto> customerFieldDtomap) {
        CustomerFieldRequestDto field=new CustomerFieldRequestDto();
        CustomerFieldOptionsValueDataDto fieldOptionsValueDataDto=new CustomerFieldOptionsValueDataDto();
        List<CustomerFieldOptionsValueDataDto> fieldValuesDataList=new ArrayList<>();
        if(customerFieldDtomap.get(pair.getKey()).getFieldValues().isEmpty())
        {
            fieldOptionsValueDataDto.setOptionId(null);
        }
        fieldOptionsValueDataDto.setValue(pair.getValue());
        fieldValuesDataList.add(fieldOptionsValueDataDto);
        field.setFieldId(customerFieldDtomap.get(pair.getKey()).getId());
        field.setFieldValuesDataList(fieldValuesDataList);
        customerFieldDtoList.add(field);

    }

    private static void populuateTicketFieldsMapping(Map.Entry<String, String> pair, List<TicketFieldDto> ticketFieldDtos, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap) {
        TicketFieldDto field=new TicketFieldDto();
        List<TicketFieldValuesDataDto> ticketFieldValuesDataList=new ArrayList<>();
        TicketFieldValuesDataDto fieldValuesData=new TicketFieldValuesDataDto();
        if(ticketFieldDtoHashMap.get(pair.getKey()).getFieldValues().isEmpty())
        {
            fieldValuesData.setOptionId(null);
        }
        field.setFieldType(ticketFieldDtoHashMap.get(pair.getKey()).getFieldType());
        fieldValuesData.setValue(pair.getValue());
        ticketFieldValuesDataList.add(fieldValuesData);
        field.setCustomLabelId(ticketFieldDtoHashMap.get(pair.getKey()).getId());
        field.setTicketFieldValuesDataList(ticketFieldValuesDataList);
        ticketFieldDtos.add(field);
    }
    public static boolean validateDescription(HashMap dto) {
        if(dto !=null && dto.get("Description")!=null && !dto.get("Description").toString().isEmpty())
        {
            return true;
        }
        return false;
    }

    public static boolean validateName(HashMap dto) {
        if(
                (dto.get("Card Name")!=null && !dto.get("Card Name").toString().isEmpty())
                        ||(dto.get("First Name")!=null && !dto.get("First Name").toString().isEmpty())
                        ||(dto.get("Last Name")!=null && !dto.get("Last Name").toString().isEmpty())
        )
        {
            return true;
        }
        return false;
    }
    public static boolean validatePsAssigned(HashMap dto, HashMap<String, Integer> brandUserDtoMap) {
        if (dto.get("Agent assigned email")!=null && !dto.get("Agent assigned email").toString().isEmpty() && brandUserDtoMap.get(dto.get("Agent assigned email").toString())!=null)
        {
            return true;
        }
        return false;
    }
    public abstract Boolean validateMandadtoryFields(HashMap dto, HashMap<String, Integer> brandUserDtoMap);
    public abstract MultiValueMap<String, Object> createThirdpartyInputDto(HashMap<String,String>  dto, HashMap<String,Integer> brandUserDtoMap, HashMap<String, CustomerFieldDto> customerFieldDtomap, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap);

    private final Integer id;
    public Integer getId() {
        return id;
    }
    private static final Map<Integer, BrandEnums> reverseMap;
    private static final Logger log = LoggerFactory.getLogger(BrandEnums.class);


    static {
        reverseMap = Arrays.stream(BrandEnums.values())
                .collect(Collectors.toMap(BrandEnums::getId, Function.identity()));
    }
    public static BrandEnums getEnumById(int id) {
        return reverseMap.get(id);
    }
    BrandEnums(Integer id) {
        this.id=id;
    }
}
