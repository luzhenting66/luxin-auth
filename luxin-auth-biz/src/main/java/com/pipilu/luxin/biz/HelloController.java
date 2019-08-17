package com.pipilu.luxin.biz;

import com.pipilu.luxin.auth.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String name(String name){
        return "hello,"+name;
    }


    @RequestMapping("/set/{name}")
    public String set(@PathVariable("name")String name){
        logger.info("-----------{}",name);
       return helloService.setName(name);
    }

    @RequestMapping("/get/{name}")
    public String get(@PathVariable("name")String name){
        return helloService.getName(name);
    }

}
