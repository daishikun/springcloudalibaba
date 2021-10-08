package com.dsk.controller;

import com.dsk.feign.ProdectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private ProdectClient prodectClient;

    @Value("${name}")
    private String name;

    @GetMapping("invoke")
    public String invokeProduct(){
        prodectClient.product(21);
        return "调用服务成功;"+name;
    }
}
