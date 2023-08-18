package com.example.FeignDemo.Util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "FeignDemo",url = "http://localhost:8054/api/v1")
public interface FeignUtil {
    @GetMapping("/name")
    String getName();
    @GetMapping("/address")
    String getAddress();
    @GetMapping("/status")
    String getStatus();




}
