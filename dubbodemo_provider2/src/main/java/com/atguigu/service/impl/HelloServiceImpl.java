package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.servicer.HelloService;

/**
 * @author 马浩明
 * @version 1.0
 * @Date2022/6/19 22:36
 */
@Service   //发布服务到注册中心。注意：使用dubbo框架提供的注解
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {

        return "8083hello," + name;
    }
}
