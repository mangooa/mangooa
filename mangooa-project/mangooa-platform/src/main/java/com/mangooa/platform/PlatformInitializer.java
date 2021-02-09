package com.mangooa.platform;

import com.mangooa.platform.manage.profile.PlatformProfileEntity;
import com.mangooa.platform.manage.profile.PlatformProfileService;
import com.mangooa.platform.tenant.TenantService;
import com.mangooa.platform.user.UserEntity;
import com.mangooa.platform.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Component
public class PlatformInitializer implements ApplicationRunner {

	@Resource
	private PlatformProperties platformProperties;

	@Resource
	private UserService userService;

	@Resource
	private PlatformProfileService platformProfileService;

	@Resource
	private TenantService tenantService;

	@Override
	public void run(ApplicationArguments args) {
		PlatformProperties.Init init = platformProperties.getInit();
		if (!init.isClose()) {
			UserEntity admin = userService.init(init);
			platformProfileService.init(admin, init);
			String tenant = admin.getTenant();
			if (tenantService.getDao().countByNameIgnoreCase(tenant) == 0) {
				tenantService.create(admin, tenant);
			}
		}
	}
}
