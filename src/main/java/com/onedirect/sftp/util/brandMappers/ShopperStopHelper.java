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
    private static Integer tagId;
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
