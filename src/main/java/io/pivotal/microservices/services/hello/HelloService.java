package io.pivotal.microservices.services.hello;

import io.pivotal.microservices.accounts.Hello;
import io.pivotal.microservices.services.web.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

@Service
public class HelloService {


    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;
    protected String serviceURL;

    protected Logger logger = Logger.getLogger(HelloService.class.getName());

    public HelloService(String serviceUrl){
        this.serviceURL = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    @PostConstruct
    public void demoOnly(){
        logger.warning("The template request factory id " + restTemplate.getRequestFactory().getClass());
    }

    public Hello getHelloString(String name){
        logger.info("findbyName invoked for "+ name);
        return restTemplate.getForObject(serviceURL + "/hello",
                Hello.class, name);
    }

    public List<Hello> getHelloList(){

    }

}
