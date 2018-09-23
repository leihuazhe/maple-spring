package com.hzways.scan.service;

import com.hzways.scan.maple.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author maple 2018.09.23 下午3:27
 */
@Service
public class HelloService {
    private Logger logger = LoggerFactory.getLogger(HelloService.class);
    @Autowired
    private HelloWorld helloWorld;

    public String sayHello(String msg) {
        logger.info("helloWorld is {}", helloWorld);
        return helloWorld.hello(msg);
    }
}
