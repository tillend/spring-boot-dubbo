package org.spring.boot.dubbo.provider.starter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Starter {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Starter.class)
			.web(WebApplicationType.NONE) // 非 Web 应用
			.run(args);
	}
}
