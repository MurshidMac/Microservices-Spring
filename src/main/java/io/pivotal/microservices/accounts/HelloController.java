package io.pivotal.microservices.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

// this is the test controller to th
@Controller
public class HelloController {
    protected Logger logger =  Logger.getLogger(HelloController.class.getName());

    @Autowired
    public HelloController(){

    }
    @RequestMapping("/hello")
    public String home(){
        return "hello";
    }


}
