package com.onedirect.sftp.service.Impl;


import com.onedirect.sftp.DTO.ThirdPartyDto.SftpTicketInputDTO;
import com.onedirect.sftp.SftpShopperstopApplication;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReadingFile {
    private static final Logger log = LoggerFactory.getLogger(SftpShopperstopApplication.class);
    public void readDataFromExcel() {

        String filePath = "/Users/Pulkityadav/Downloads/SS- Sample-Ticket Creation (1).xlsx";
        List<SftpTicketInputDTO> sftpTicketInputDTOS = new ArrayList<>();
        try {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            XSSFWorkbook workbook = null;
            try {
                workbook = new XSSFWorkbook(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            XSSFSheet sheet = workbook.getSheetAt(0);


            List<String> columnNames = new ArrayList<>();
            XSSFRow startRow = (XSSFRow) sheet.getRow(0);
            int rows = sheet.getLastRowNum();
            int cells = sheet.getRow(0).getLastCellNum();
            for (int cell = 0; cell < cells; cell++) {
                XSSFCell cellValue = (XSSFCell) startRow.getCell(cell);
                columnNames.add(cellValue.getStringCellValue());
            }

            for (int row = 1; row <=rows; row++) {
                XSSFRow xssfRow = (XSSFRow) sheet.getRow(row);
                SftpTicketInputDTO sftpTicketInputDTO = new SftpTicketInputDTO();
                for (int cell = 0; cell < cells; cell++) {
                    XSSFCell xssfCell = (XSSFCell) xssfRow.getCell(cell);
                    String cellColumn = columnNames.get(cell);
                    log.info("cell type " + xssfCell.getCellType());
                    switch (xssfCell.getCellType()) {

                        case STRING:
                            try {
                                sftpTicketInputDTO.getClass().getDeclaredField(cellColumn).set(sftpTicketInputDTO,
                                        xssfCell.getStringCellValue());
                            } catch (NoSuchFieldException e) {
                                throw new RuntimeException(e);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }

                            break;

                        case NUMERIC:
                            try {
                                if(DateUtil.isCellDateFormatted(xssfCell))
                                {
                                    Date date = xssfCell.getDateCellValue();
                                    long yourmilliseconds = date.getTime();
                                    LocalDateTime localDateTime = Instant.ofEpochMilli(yourmilliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
                                    String dateTime = localDateTime.toString();
                                    dateTime = dateTime.replace('T',' ');
                                    sftpTicketInputDTO.getClass().getDeclaredField(cellColumn).set(sftpTicketInputDTO,
                                            dateTime);
                                }
                                else {
                                    DataFormatter formatter = new DataFormatter();
                                    sftpTicketInputDTO.getClass().getDeclaredField(cellColumn).set(sftpTicketInputDTO,
                                            String.valueOf(formatter.formatCellValue(xssfCell)));
                                }
                            } catch (NoSuchFieldException e) {
                                throw new RuntimeException(e);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                            break;

                        case FORMULA:
                            try {
                                sftpTicketInputDTO.getClass().getDeclaredField(cellColumn).set(sftpTicketInputDTO,
                                        xssfCell.getRawValue() + "");
                            } catch (NoSuchFieldException e) {
                                throw new RuntimeException(e);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                    }
                }
                log.info("TicketInput DTO :: {}", sftpTicketInputDTO.toString());
                sftpTicketInputDTOS.add(sftpTicketInputDTO);

            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        log.info("Dto recieved is {}", sftpTicketInputDTOS);
    }

}
