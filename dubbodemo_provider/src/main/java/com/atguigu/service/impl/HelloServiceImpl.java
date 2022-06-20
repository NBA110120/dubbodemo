package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.HelloService;

/**
 * @author 马浩明
 * @version 1.0
 * @Date2022/6/19 22:36
 */
@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {

        return "hello," + name;
    }
}
