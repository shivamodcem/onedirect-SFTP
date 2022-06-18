package com.onedirect.sftp.controller;
import com.onedirect.sftp.DTO.BrandUserDto.BrandUserDto;
import com.onedirect.sftp.DTO.CustomerFieldDto.CustomerFieldDetailedDto;
import com.onedirect.sftp.DTO.ThirdPartyDto.ThirdPartyTicketInputDto;
import com.onedirect.sftp.DTO.TicketFieldBrandDto.TicketFieldDTO;
import com.onedirect.sftp.SftpShopperstopApplication;
import com.onedirect.sftp.service.Impl.ExtractBrandUsersImpl;
import com.onedirect.sftp.service.Impl.ExtractCustomerFieldImpl;
import com.onedirect.sftp.service.Impl.ExtractTicketFieldImpl;
import com.onedirect.sftp.service.Impl.ReadingFile;
import com.onedirect.sftp.service.SendToThirdParty;
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
    private static final Logger log = LoggerFactory.getLogger(SftpShopperstopApplication.class);
    @Autowired
    private ExtractBrandUsersImpl extractBrandUsers;

    @Autowired
    private ExtractTicketFieldImpl extractTicketField;

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
            brandUserDtoMap=extractBrandUsers.ObjectToMap(brandUserDtoList);
            log.info("brand user map {}",brandUserDtoMap);
        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);

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

        try{
            log.info("calling func");
//            ThirdPartyTicketInputDto thirdPartyTicketInputDto = new ThirdPartyTicketInputDto("Shivam",
//                    "Testing Sftp",0,4523523,3255,new ArrayList<>(),1,0);
            List<NameValuePair> nameValuePairList=new ArrayList<>();
            nameValuePairList.add(new BasicNameValuePair("name","Shivam"));
            nameValuePairList.add(new BasicNameValuePair("description","Descr"));
            nameValuePairList.add(new BasicNameValuePair("resourceType",Integer.toString(0)));
            nameValuePairList.add(new BasicNameValuePair("assignedTo",Integer.toString(4523523)));
            nameValuePairList.add(new BasicNameValuePair("teamId",Integer.toString(3255)));
            nameValuePairList.add(new BasicNameValuePair("ticketFields",new ArrayList<>().toString()));
            nameValuePairList.add(new BasicNameValuePair("ticketFormId",Integer.toString(1209)));
            nameValuePairList.add(new BasicNameValuePair("ticketFormType",Integer.toString(0)));
            Boolean bool=sendToThirdParty.SendTicket(nameValuePairList);
            return bool?new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (Exception e)
        {
            log.error("Exception Occured due to {}",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @RequestMapping(value="/status", method= RequestMethod.GET)
    public ResponseEntity<String> status()  {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
