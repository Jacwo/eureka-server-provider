package com.yyl.provider.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author yangyuanliang
 */
@RestController
public class HelloController {
    private final Logger logger=Logger.getLogger(HelloController.class);
    @Autowired
    private DiscoveryClient client;
    @RequestMapping("/test/cache")
    public Integer getRandomInteger(){
        Random random=new Random();
        return random.nextInt(99999);
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        $aa();
        ServiceInstance serviceInstance=client.getLocalServiceInstance();
        logger.info("/hello host:"+serviceInstance.getHost());
        return "hello";
    }
    public void $aa() {
        String _name = "name";
    }
}
