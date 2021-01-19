package com.mangooa.server.tenant;

import com.mangooa.server.ServerAppProperties;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Order(2)
@Component
public class TenantInitializer implements ApplicationRunner {

	private final TenantService service;

	private final ServerAppProperties properties;

	public TenantInitializer(TenantService service, ServerAppProperties properties) {
		this.service = service;
		this.properties = properties;
	}

	@Override
	public void run(ApplicationArguments args) {
		service.init(properties);
	}
}
