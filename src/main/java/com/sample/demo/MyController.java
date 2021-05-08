package com.sample.demo.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.util.List;

@Controller
public class MyController {

private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

  @GetMapping("/")
     public ResponseEntity<String> healthcheck() {
         return ResponseEntity.status(HttpStatus.OK).body("");
     }

     @GetMapping("/check.txt")
     public ResponseEntity<String> getOk() {
         LOGGER.info("200 reponse");
         return ResponseEntity.status(HttpStatus.OK).body("Its working!!!");
     }


     @GetMapping("/404")
     public ResponseEntity<String> getNotFound() {
        LOGGER.error("404 ERROR");
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
     }
    


     @GetMapping("/403")
     public ResponseEntity<String> getForbidden() {
                 LOGGER.error("403 ERROR");
         return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Forbidden");
     }
    



     @GetMapping("/500")
     public ResponseEntity<String> getServerError() {   
         LOGGER.error("500 ERROR");  
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Application error");
     }
    



     @GetMapping("/502")
     public ResponseEntity<String> getBadGateway() {
         LOGGER.error("502 ERROR");
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Bad Gateway");

     }
    
    
}
