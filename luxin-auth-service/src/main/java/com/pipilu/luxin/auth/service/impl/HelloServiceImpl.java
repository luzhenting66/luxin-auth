package com.pipilu.luxin.auth.service.impl;

import com.pipilu.luxin.auth.service.HelloService;
import com.pipilu.plus.plusutils.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
   @Autowired
   RedisUtils redisUtils;

    @Override
    public String getName(String name) {

        Object o = redisUtils.get(name);
        return (String) o;
    }

    @Override
    public String setName(String name) {

        redisUtils.set(name,"hello,redis...."+name,0);
        return "success";
    }
}
