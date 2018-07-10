package io.pivotal.microservices.services.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaServer
public class HelloServer {

    public static final String ACCOUNT_SERVICES_URL = "http://ACCOUNTS-SERVICE";

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "hello-server");
        SpringApplication.run(HelloServer.class,args);
    }

}
