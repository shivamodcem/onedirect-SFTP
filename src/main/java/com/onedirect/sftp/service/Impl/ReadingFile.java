package com.onedirect.sftp.service.Impl;


import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ReadingFile {
    private static final Logger log = LoggerFactory.getLogger(ReadingFile.class);
    public void readDataFromExcel(List<HashMap<String, String>> sftpTicketInputDTOS) {

        String filePathSrc = "/Users/chaudhary/Downloads/sheet.xlsx";
        String filePathDes="/Users/chaudhary";
        try {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(filePathSrc);
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException(e.getMessage());
            }
            XSSFWorkbook workbook = null;
            try {
                workbook = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            int lastSheetNum = workbook.getNumberOfSheets();
            for (int sheetNum = 0; sheetNum < lastSheetNum; sheetNum++) {

                XSSFSheet sheet = workbook.getSheetAt(sheetNum);


                List<String> columnNames = new ArrayList<>();
                XSSFRow startRow = (XSSFRow) sheet.getRow(0);
                int rows = sheet.getLastRowNum();
                int cells = sheet.getRow(0).getLastCellNum();
                for (int cell = 0; cell < cells; cell++) {
                    XSSFCell cellValue = (XSSFCell) startRow.getCell(cell);
                    columnNames.add(cellValue.getStringCellValue());
                }

                for (int row = 1; row <= rows; row++) {

                    XSSFRow xssfRow = (XSSFRow) sheet.getRow(row);
                    if(isRowEmpty(xssfRow))break;
                    HashMap<String,String> FieldMap = new HashMap<>();
                    for (int cell = 0; cell < cells; cell++) {
                        XSSFCell xssfCell = (XSSFCell) xssfRow.getCell(cell);
                        String cellColumn = columnNames.get(cell);
                        log.info("cell type " + xssfCell.getCellType());
                        switch (xssfCell.getCellType()) {

                            case STRING:
                                    FieldMap.put(cellColumn,xssfCell.getStringCellValue());
                                    break;

                            case NUMERIC:
                                    if (DateUtil.isCellDateFormatted(xssfCell)) {
                                        Date date = xssfCell.getDateCellValue();
                                        long yourmilliseconds = date.getTime();
                                        LocalDateTime localDateTime = Instant.ofEpochMilli(yourmilliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
                                        String dateTime = localDateTime.toString();
                                        dateTime = dateTime.replace('T', ' ');
                                        FieldMap.put(cellColumn,dateTime);
                                    } else {
                                        DataFormatter formatter = new DataFormatter();
                                        FieldMap.put(cellColumn,formatter.formatCellValue(xssfCell));
                                    }
                                break;

                            case FORMULA:
                                FieldMap.put(cellColumn, xssfCell.getRawValue() + "");
                                break;
                        }
                    }
                    if(FieldMap==null || FieldMap.isEmpty())
                    {
                        log.error("Encountered Problem while reading Fields");
                    }
                    else {
                        log.info("TicketInput Field :: {}",FieldMap);
                        sftpTicketInputDTOS.add(FieldMap);
                    }


                }
            }
//            moveFile(filePathSrc,filePathDes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("Dto recieved is {}", sftpTicketInputDTOS);
    }
    public static boolean isRowEmpty(XSSFRow row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            XSSFCell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK)
                return false;
        }
        return true;
    }

    public void moveFile(String src,String des) throws IOException {
        FileUtils.moveFileToDirectory(
                FileUtils.getFile(src),
                FileUtils.getFile(des), true);
    }

}
