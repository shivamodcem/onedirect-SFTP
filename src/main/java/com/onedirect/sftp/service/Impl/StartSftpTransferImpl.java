package com.onedirect.sftp.service.Impl;

import com.onedirect.sftp.DTO.BrandUserDto.BrandUserDto;
import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDto;
import com.onedirect.sftp.DTO.TicketFieldBrandDto.TicketFieldDTO;
import com.onedirect.sftp.enums.BrandEnums;
import com.onedirect.sftp.service.SendToThirdParty;
import com.onedirect.sftp.service.StartSftpTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StartSftpTransferImpl implements StartSftpTransfer {
    @Autowired
    private ReadingFile readingFile;
    private static final Logger log = LoggerFactory.getLogger(StartSftpTransferImpl.class);
    @Autowired
    private ExtractBrandUsersImpl extractBrandUsers;

    @Autowired
    private ExtractTicketFieldImpl extractTicketField;


    @Autowired
    private ExtractCustomerFieldImpl extractCustomerField;
    @Autowired
    private SendToThirdParty sendToThirdParty;

    @Override
    public void sftpTransfer(Integer brandId) {
        HashMap<String,Integer> brandUserDtoMap=new HashMap<>();
        List<HashMap<String,String>> sftpTicketInputDTOS=new ArrayList<>();
        HashMap<String, CustomerFieldDto> custFieldDTOS=new HashMap<>();
        HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap=new HashMap<>();

        try{
            getAgents(brandUserDtoMap);//validated
            if(brandUserDtoMap==null || brandUserDtoMap.isEmpty())
            {
                log.error("Brand Users detail cant be extracted");
                throw new Exception("Exception while extracting brand user details");
            }
            custFieldDTOS=extractCustomerField.ObjectToMap(extractCustomerField.getCustomerField());
            if(custFieldDTOS==null || custFieldDTOS.isEmpty()) //validated
            {
                log.error("Customer Field detail cant be extracted");
                throw new Exception("Exception while extracting brand user details");
            }
            ticketFieldDtoHashMap=extractTicketField.dtoToMap(extractTicketField.getTotalTicketFields());
            if(ticketFieldDtoHashMap==null || ticketFieldDtoHashMap.isEmpty()) //validated
            {
                log.error("Ticket Field detail cant be extracted");
                throw new Exception("Exception while extracting brand user details");
            }

            readingFile.readDataFromExcel(sftpTicketInputDTOS);
            if(sftpTicketInputDTOS==null || sftpTicketInputDTOS.isEmpty())
            {
                log.error("Brand Users detail cant be extracted");
                throw new Exception("Exception while extracting brand user details");
            }
            for(HashMap<String,String>  dto:sftpTicketInputDTOS)
            {
                MultiValueMap<String, Object> thirdPartyDtoNameValuePairList = new LinkedMultiValueMap<>();
                try{
                    if(BrandEnums.getEnumById(brandId).validateMandadtoryFields(dto,brandUserDtoMap))
                    {
                         thirdPartyDtoNameValuePairList= BrandEnums.getEnumById(brandId).createThirdpartyInputDto(dto,brandUserDtoMap,custFieldDTOS,ticketFieldDtoHashMap);
                        String responseString=sendToThirdParty.SendTicket(thirdPartyDtoNameValuePairList);
                        log.info("Ticket created with credential {}",responseString);
                    }
                    else
                    {
                        throw new Exception("Validation failed for Ticket");
                    }


                }
                catch (Exception ex)
                {
                    log.error("exception occured while sending dto to 3rd party because of {} for {}",ex,thirdPartyDtoNameValuePairList);
                }
            }
            readingFile.moveFileHelper();
        }
        catch (Exception ex)
        {
            log.error("exception occured {}",ex);

        }

    }



    private void getAgents(HashMap<String,Integer> brandUserDtoMap) throws RuntimeException {
        List<BrandUserDto> brandUserDtoList=new ArrayList<>();
        try{
            brandUserDtoList=extractBrandUsers.getTotalUsers();
            if(brandUserDtoList==null || brandUserDtoList.isEmpty())
            {
                throw new Exception("Users Not Found in isApi");
            }
            extractBrandUsers.ObjectToMap(brandUserDtoMap,brandUserDtoList);
            log.info("brand user map {}",brandUserDtoMap);
        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            throw new RuntimeException((e.getMessage()));
        }
    }

//    private MultiValueMap<String, Object> createThirdpartyInputDtoForShopperStop(HashMap<String,String>  dto, HashMap<String,Integer> brandUserDtoMap, HashMap<String, CustomerFieldDto> customerFieldDtomap, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap) {
//        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
//        List<CustomerFieldRequestDto> customerFieldDtoList=new ArrayList<>();
//        List<TicketFieldDto> ticketFieldDtos=new ArrayList<>();
//        getAllFieldsPopulated(dto,ticketFieldDtos,customerFieldDtoList,customerFieldDtomap,ticketFieldDtoHashMap);
//        String name=getName(dto);
//        map.add("name",name);
//        map.add("description",dto.get("Description"));
//        map.add("assignedTo",brandUserDtoMap.get(dto.get("Agent assigned email")));
//        map.add("ticketFields",ticketFieldDtos);
//        map.add("customerField",customerFieldDtoList);
//        map.add("resourceType",0);
//        map.add("tags",tagId);
////        map.add("applyTicketRules", true);
//        log.info("map is {}",map);
//        return map;
//    }
//
//    private String getName(HashMap<String, String> dto) {
//        if(dto.get("Card Name")!=null)
//        {
//            return dto.get("Card Name");
//        }
//        else
//        {
//            String name="";
//            if(dto.get("First Name")!=null)name+=dto.get("First Name");
//            if(dto.get("Last Name")!=null)name+=dto.get("Last Name");
//            return name;
//        }
//    }
//
//    private void getAllFieldsPopulated(HashMap<String,String> dto, List<TicketFieldDto> ticketFieldDtos, List<CustomerFieldRequestDto> customerFieldDtoList, HashMap<String, CustomerFieldDto> customerFieldDtomap, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap) {
//        for(Map.Entry<String, String> pair : dto.entrySet())
//        {
//            if(shopperfieldMap.get(pair.getKey())==null)continue;
//
//            if(shopperfieldMap.get(pair.getKey())==0) //TicketField is 0
//            {
//                populuateTicketFieldsMapping(pair,ticketFieldDtos,ticketFieldDtoHashMap);
//            }
//            else if(shopperfieldMap.get(pair.getKey())==1) //TicketField is 1
//            {
//                populateCustomerFieldsMapping(pair,customerFieldDtoList,customerFieldDtomap);
//            }
//        }
//    }
//
//
//    private void populateCustomerFieldsMapping(Map.Entry<String, String> pair, List<CustomerFieldRequestDto> customerFieldDtoList, HashMap<String, CustomerFieldDto> customerFieldDtomap) {
//        CustomerFieldRequestDto field=new CustomerFieldRequestDto();
//        CustomerFieldOptionsValueDataDto fieldOptionsValueDataDto=new CustomerFieldOptionsValueDataDto();
//        List<CustomerFieldOptionsValueDataDto> fieldValuesDataList=new ArrayList<>();
//        if(customerFieldDtomap.get(pair.getKey()).getFieldValues().isEmpty())
//        {
//            fieldOptionsValueDataDto.setOptionId(null);
//        }
//        fieldOptionsValueDataDto.setValue(pair.getValue());
//        fieldValuesDataList.add(fieldOptionsValueDataDto);
//        field.setFieldId(customerFieldDtomap.get(pair.getKey()).getId());
//        field.setFieldValuesDataList(fieldValuesDataList);
//        customerFieldDtoList.add(field);
//
//    }
//
//    private void populuateTicketFieldsMapping(Map.Entry<String, String> pair, List<TicketFieldDto> ticketFieldDtos, HashMap<String, TicketFieldDTO> ticketFieldDtoHashMap) {
//        TicketFieldDto field=new TicketFieldDto();
//        List<TicketFieldValuesDataDto> ticketFieldValuesDataList=new ArrayList<>();
//        TicketFieldValuesDataDto fieldValuesData=new TicketFieldValuesDataDto();
//        if(ticketFieldDtoHashMap.get(pair.getKey()).getFieldValues().isEmpty())
//        {
//            fieldValuesData.setOptionId(null);
//        }
//        field.setFieldType(ticketFieldDtoHashMap.get(pair.getKey()).getFieldType());
//        fieldValuesData.setValue(pair.getValue());
//        ticketFieldValuesDataList.add(fieldValuesData);
//        field.setCustomLabelId(ticketFieldDtoHashMap.get(pair.getKey()).getId());
//        field.setTicketFieldValuesDataList(ticketFieldValuesDataList);
//        ticketFieldDtos.add(field);
//    }

}
