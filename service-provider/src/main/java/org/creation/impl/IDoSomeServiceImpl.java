package org.creation.impl;

import org.creation.IDoSomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IDoSomeServiceImpl implements IDoSomeService {
    @RequestMapping("/doSome")
    @Override
    public String doSome() {
        System.out.println("service provider");
        return "eureka arrived web hello world!";
    }
}
