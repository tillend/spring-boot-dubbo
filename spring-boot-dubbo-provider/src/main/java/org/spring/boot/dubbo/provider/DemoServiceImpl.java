package org.spring.boot.dubbo.provider;

import javax.validation.Valid;

import org.spring.boot.dubbo.api.DemoService;
import org.spring.boot.dubbo.api.model.Word;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0", 
        timeout = 2000, 
        validation = "true",
        retries = 2,
        loadbalance = "random")
public class DemoServiceImpl implements DemoService {

    @Override
    public String saySomething(@Valid Word word) {
        return StringUtils.isNotEmpty(word.getWord()) ? word.getWord() : "Say you won't let go";
    }

}
