package org.spring.boot.dubbo.consumer.controller;

import org.spring.boot.dubbo.api.DemoService;
import org.spring.boot.dubbo.api.model.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class DemoController {

    @Reference(version = "${demo.service.version}", url = "dubbo://localhost:9900")
    private DemoService demoService;

    @RequestMapping("/saySomething")
    public String sayHello(String name) {
        Word word = new Word();
        word.setWord(name);

        return demoService.saySomething(word);
    }
}
