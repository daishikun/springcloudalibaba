package com.dsk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/product")
    public String product(Integer id){
        System.out.println(1111);
        return "商品服务成功"+id+";端口为"+port;
    }
}
