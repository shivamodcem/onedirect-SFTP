package com.onedirect.sftp.util.brandMappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Component
@PropertySource("classpath:application.properties")
public class ShopperStopHelper {

//    private static Integer teamId;

    @Value("#{${shopperfieldMap}}")
    public void setshopperfieldMap(HashMap<String,Integer> shopperfieldMap)
    {
        ShopperStopHelper.shopperfieldMap=shopperfieldMap;
    }
    private static HashMap<String,Integer> shopperfieldMap;
    @Value("${shopperTag}")
    public void setshopperfieldMap(Integer tagId)
    {
        ShopperStopHelper.tagId=tagId;
    }
//    @Value("${shopperTeamId}")
//    public void setshopperTeamId(Integer teamId)
//    {
//        ShopperStopHelper.teamId=teamId;
//    }
//    @Value("${shopperTicketFormId}")
//    public void setShopperTicketFormId(Integer shopperTicketFormId)
//    {
//        ShopperStopHelper.shopperTicketFormId=shopperTicketFormId;
//    }
//    @Value("${shopperTicketFormType}")
//    public void setShopperTicketFormType(Integer shopperTicketFormType)
//    {
//        ShopperStopHelper.shopperTicketFormType=shopperTicketFormType;
//    }
    private static Integer tagId;
//    private static Integer shopperTicketFormId;
//    private static Integer shopperTicketFormType;
//    public static Integer getTeamId(){return teamId;}
//    public static Integer getShopperTicketFormId(){return shopperTicketFormId;}
//    public static Integer getShopperTicketFormType(){return shopperTicketFormType;}

    private static final Logger log = LoggerFactory.getLogger(ShopperStopHelper.class);
    public static HashMap<String,Integer>  getFieldMapping()
    {
        return shopperfieldMap;
    }
    public static Integer getTag()
    {
        return tagId;
    }
}
