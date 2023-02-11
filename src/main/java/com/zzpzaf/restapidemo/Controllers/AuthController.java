package com.zzpzaf.restapidemo.Controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@RequestMapping("/api")
public class AuthController {

    private final Log logger = LogFactory.getLog(getClass());


    @PostMapping("/login")
	public ResponseEntity<String> login() {
		//return "login";
        String msg = "Hello from Login!";
        logger.info(msg);
        try {
        
            return new ResponseEntity<>(msg, HttpStatus.OK);    

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}

    @GetMapping("/")
    public ResponseEntity<String> myhome() {

        String msg = "Hello from home!";
        logger.info(msg);

        try {
        
            return new ResponseEntity<>(msg, HttpStatus.OK);    

        } catch (Exception e) {
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/error")
    public ResponseEntity<String> error() {
        
        String msg = "An Error occured!";
        logger.info(msg);
         
        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
}