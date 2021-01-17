package com.mangooa.server.tenant;

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

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("222222222222");
	}
}
