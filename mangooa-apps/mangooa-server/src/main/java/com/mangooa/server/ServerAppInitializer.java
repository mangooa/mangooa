package com.mangooa.server;

import com.mangooa.server.app.AppService;
import com.mangooa.server.profile.ServerProfileService;
import com.mangooa.server.tenant.TenantService;
import com.mangooa.server.uaa.user.User;
import com.mangooa.server.uaa.user.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.mangooa.server.ServerAppConstant.INIT_ADMIN_ACCOUNT;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Order(1)
@Component
public class ServerAppInitializer implements ApplicationRunner {

	private final ServerAppProperties properties;
	private final UserService userService;
	private final ServerProfileService serverProfileService;
	private final TenantService tenantService;
	private final AppService appService;

	public ServerAppInitializer(ServerAppProperties properties, UserService userService,
								ServerProfileService serverProfileService,
								TenantService tenantService,
								AppService appService) {
		this.properties = properties;
		this.userService = userService;
		this.serverProfileService = serverProfileService;
		this.tenantService = tenantService;
		this.appService = appService;
	}

	@Override
	public void run(ApplicationArguments args) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable()) {
			userService.init(properties);
			User admin = userService.find(INIT_ADMIN_ACCOUNT);
			serverProfileService.init(properties, admin);
			tenantService.init(properties, admin);
			appService.init(properties, admin);
		}
	}
}
