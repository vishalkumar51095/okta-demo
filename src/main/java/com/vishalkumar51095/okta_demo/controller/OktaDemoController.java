package com.vishalkumar51095.okta_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/okta")
public class OktaDemoController {

    @GetMapping("/secured")
    public ResponseEntity<String> getStringByPassingToken(){
        return new ResponseEntity<>("Congratualations !! our access token is valid Go ahead!!", HttpStatus.OK);
    }
}
