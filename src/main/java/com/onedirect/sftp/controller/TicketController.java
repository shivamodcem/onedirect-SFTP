package com.onedirect.sftp.controller;
import com.onedirect.sftp.DTO.BrandUserDto.BrandUserDto;
import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDetailedDto;
import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.CustomerFieldOptionsValueDataDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.CustomerFieldRequestDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.SftpTicketInputDTO;
import com.onedirect.sftp.DTO.ThirdPartyDto.ThirdPartyTicketInputDto;
import com.onedirect.sftp.DTO.TicketFieldBrandDto.TicketFieldDTO;
import com.onedirect.sftp.SftpShopperstopApplication;
import com.onedirect.sftp.service.Impl.ExtractBrandUsersImpl;
import com.onedirect.sftp.service.Impl.ExtractCustomerFieldImpl;
import com.onedirect.sftp.service.Impl.ExtractTicketFieldImpl;
import com.onedirect.sftp.service.Impl.ReadingFile;
import com.onedirect.sftp.service.SendToThirdParty;
import com.onedirect.sftp.service.StartSftpTransfer;
import javafx.util.Pair;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@ComponentScan
public class TicketController {

    @Autowired
    private ReadingFile readingFile;
    private static final Logger log = LoggerFactory.getLogger(TicketController.class);
    @Autowired
    private ExtractBrandUsersImpl extractBrandUsers;

    @Autowired
    private ExtractTicketFieldImpl extractTicketField;

    @Autowired
    private StartSftpTransfer startSftpTransfer;


    @Autowired
    private ExtractCustomerFieldImpl extractCustomerField;
    @Autowired
    private SendToThirdParty sendToThirdParty;


    @RequestMapping(value="/agent", method= RequestMethod.POST)
    public ResponseEntity<String> call(){
        List<BrandUserDto> brandUserDtoList=new ArrayList<>();
        try{
            log.info("calling func");
            brandUserDtoList=extractBrandUsers.getTotalUsers();
            if(brandUserDtoList==null || brandUserDtoList.isEmpty())
            {
                log.error("Users Not Found in isApi");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            HashMap<String,Integer>brandUserDtoMap=new HashMap<>();
            extractBrandUsers.ObjectToMap(brandUserDtoMap,brandUserDtoList);
            log.info("brand user map {}",brandUserDtoMap);
        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(value="/read", method= RequestMethod.POST)
    public ResponseEntity<String> read() {
        List<HashMap<String,String>> sftpTicketInputDTOS = new ArrayList<>();
        try {
            readingFile.readDataFromExcel(sftpTicketInputDTOS);
        } catch (Exception ex) {
            log.error("error occured while trying to read data from sheet {}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(sftpTicketInputDTOS.toString(), HttpStatus.OK);

    }

    @RequestMapping(value="/tick", method= RequestMethod.POST)
    public ResponseEntity<String> brand(){
        List<TicketFieldDTO> ticketFieldDTOS=new ArrayList<>();
        try{
            log.info("calling func");
//            readingFile.readDataFromExcel();
            ticketFieldDTOS=extractTicketField.getTotalTicketFields();
            if(ticketFieldDTOS==null || ticketFieldDTOS.isEmpty())
            {
                log.error("TicketFields Not Found in BrandApi");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @RequestMapping(value="/cust", method= RequestMethod.POST)
    public ResponseEntity<String> cust(){
        CustomerFieldDetailedDto custFieldDTOS=null;
        try{
            log.info("calling func");
//            readingFile.readDataFromExcel();
            custFieldDTOS=extractCustomerField.getCustomerField();
            if(custFieldDTOS==null)
            {
                log.error("Fields Not Found in BrandApi customerFields");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @RequestMapping(value="/send", method= RequestMethod.POST)
    public ResponseEntity<String> send(){
//        [{"fieldId":"30","fieldValuesDataList":[{"value":"9898989898","optionId":null}],"fieldType":16,"defaultType":1}
        try{
            log.info("calling func");
            HashMap<String, CustomerFieldDto> custFieldDTOS=extractCustomerField.ObjectToMap(extractCustomerField.getCustomerField());

            CustomerFieldRequestDto phone=new CustomerFieldRequestDto();
            List<CustomerFieldOptionsValueDataDto> fieldValuesDataList=new ArrayList<>();
            CustomerFieldOptionsValueDataDto fieldOptionsValueDataDto=new CustomerFieldOptionsValueDataDto();
            fieldOptionsValueDataDto.setValue("9898989898");
            if(custFieldDTOS.get("Phone").getFieldValues().isEmpty())
            {
                fieldOptionsValueDataDto.setOptionId(null);
            }

            fieldValuesDataList.add(fieldOptionsValueDataDto);
            phone.setFieldId(custFieldDTOS.get("Phone").getId());
            phone.setFieldValuesDataList(fieldValuesDataList);
            List<CustomerFieldRequestDto> customerFieldDtoList=new ArrayList<>();
            customerFieldDtoList.add(phone);
            log.info(phone.toString());
            MultiValueMap<String, Object> nameValuePairList = new LinkedMultiValueMap<>();
            nameValuePairList.add("name","Shivam");
            nameValuePairList.add("description","Descr");
            nameValuePairList.add("resourceType",0);
            nameValuePairList.add("assignedTo",4523523);
            nameValuePairList.add("teamId",3255);
            nameValuePairList.add("ticketFields",new ArrayList<>());
            nameValuePairList.add("ticketFormId",1209);
            nameValuePairList.add("ticketFormType",0);
            nameValuePairList.add("customerField",customerFieldDtoList);
            String responseString=sendToThirdParty.SendTicket(nameValuePairList);
            return new ResponseEntity<>(responseString,HttpStatus.OK);
        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @RequestMapping(value="/status", method= RequestMethod.GET)
    public ResponseEntity<String> status()  {
        startSftpTransfer.sftpTransfer(6221);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
