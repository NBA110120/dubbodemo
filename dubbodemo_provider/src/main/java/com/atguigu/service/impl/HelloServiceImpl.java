package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.servicer.HelloService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 马浩明
 * @version 1.0
 * @Date2022/6/19 22:36
 */


/**
 * dubbo继承声明式事务，导致服务发布不成功
 * 原因：事务生成代理类com.sun.proxy.￥Proxy35，由于包扫描和代理类不是同一个，所以，导致无法发布服务。
 *
 * 解决：
 *      1.将代理方式进行修改：proxy-target-class="true" 将JDK动态代理（基于接口代理方式）修改为Cglib代理(基于继承方式)
 *      2.发布服务时需要设置接口类型@Service(interfaceClass = HelloService.class)
 */
@Service(interfaceClass = HelloService.class)   //发布服务到注册中心。注意：使用dubbo框架提供的注解
@Transactional
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {

        return "8081hello," + name;
    }
}
