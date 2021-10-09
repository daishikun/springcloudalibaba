package com.dsk.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.dsk.feign.ProdectClient;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLDocument;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private ProdectClient prodectClient;

    @Value("${name}")
    private String name;

    // 后为默认  fallback业务的默认方案  
    @GetMapping("invoke")
    @SentinelResource(value = "aaa",blockHandler ="blockHandler" ,defaultFallback = "")
    public String invokeProduct(Integer id){
        prodectClient.product(21);
        return "调用服务成功;"+name;
    }

    public String blockHandler(Integer id, BlockException e){
        if (e instanceof ParamFlowException){
            return "被热点参数限流";
        }
        return "123";

    }
}
