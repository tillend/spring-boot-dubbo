package org.spring.boot.dubbo.provider;

import org.spring.boot.dubbo.api.DemoService;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
	public String saySomething(String word) {
		return StringUtils.isNotEmpty(word) ? word : "Say you won't let go";
	}

}
