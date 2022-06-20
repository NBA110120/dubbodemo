package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.servicer.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 马浩明
 * @version 1.0
 * @Date2022/6/19 22:48
 */
@RestController
@RequestMapping("/demo")
public class HelloController {

    //@Reference  //从2181上订阅服务。注解使用dubbo框架提供的。com.alibaba.dubbo.config.annotation.Reference;
    @Reference(loadbalance = "roundrobin")
    private HelloService helloService;//动态代领机制

    @RequestMapping("/hello")
    @ResponseBody
    public String getName(String name){

        String msg = helloService.sayHello(name);
        System.out.println(msg);
        return msg;
    }
}
