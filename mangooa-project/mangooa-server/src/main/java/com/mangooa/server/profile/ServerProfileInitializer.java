package com.mangooa.server.profile;

import com.mangooa.server.ServerAppProperties;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务器配置初始化器。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Order(1)
@Component
public class ServerProfileInitializer implements ApplicationRunner {

	private final ServerProfileService service;

	private final ServerAppProperties properties;

	public ServerProfileInitializer(ServerProfileService service, ServerAppProperties properties) {
		this.service = service;
		this.properties = properties;
	}

	@Override
	public void run(ApplicationArguments args) {
		service.init(properties);
	}
}
