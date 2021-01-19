package com.mangooa.server.uaaa.user;

import com.mangooa.server.ServerAppProperties;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Order(3)
@Component
public class UserInitializer implements ApplicationRunner {

	private final UserService userService;

	private final ServerAppProperties properties;

	public UserInitializer(UserService userService, ServerAppProperties properties) {
		this.userService = userService;
		this.properties = properties;
	}

	@Override
	public void run(ApplicationArguments args) {
		userService.init(properties);
	}
}
