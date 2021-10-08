package com.dsk.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("CLIENT2")
public interface ProdectClient {

    @GetMapping("/product")
    String product(@RequestParam("id") Integer id);

}
