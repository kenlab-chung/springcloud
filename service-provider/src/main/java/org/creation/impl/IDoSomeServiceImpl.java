package org.creation.impl;

import org.creation.IDoSomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IDoSomeServiceImpl implements IDoSomeService {
    private int count =0;
    @RequestMapping("/doSome")
    @Override
    public String doSome() {
        count++;
        return String.format("eureka arrived web hello world!(%d)",count);
    }
}
