package com.onedirect.sftp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    @GetMapping(value = "/status")
    public ResponseEntity<String> status(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
