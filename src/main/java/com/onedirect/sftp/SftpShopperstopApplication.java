package com.onedirect.sftp;

import com.onedirect.sftp.config.*;
import com.onedirect.sftp.service.StartSftpTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class SftpShopperstopApplication {


    private static final Logger log = LoggerFactory.getLogger(SftpShopperstopApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SftpShopperstopApplication.class, args);
    }
    @Bean
    ApplicationRunner applicationRunner(StartSftpTransfer startSftpTransfer, InterCommConfig interCommConfig, ConfigurableApplicationContext context) {
        return (applicationArguments) -> {
            if(applicationArguments.containsOption("brandId") && applicationArguments.containsOption("brandUserId") && applicationArguments.containsOption("productId"))
            {

                interCommConfig.setBrandId(Integer.valueOf(applicationArguments.getOptionValues("brandId").get(0)));
                interCommConfig.setBrandUserId(Integer.valueOf(applicationArguments.getOptionValues("brandUserId").get(0)));
                interCommConfig.setProductId(Byte.valueOf(applicationArguments.getOptionValues("productId").get(0)));
                Long start=System.currentTimeMillis();
                log.info("Starting SFTP service");
                startSftpTransfer.sftpTransfer(Integer.valueOf(applicationArguments.getOptionValues("brandId").get(0)));
                log.info("Time taken for running SFTP was {} ms",System.currentTimeMillis()-start);
                context.close();
            }

        };
    }


}
