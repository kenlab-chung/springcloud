package org.creation.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name ="eureka-provider")
public interface HelloService {
    @GetMapping("/doSome")
    String doSome();
}
