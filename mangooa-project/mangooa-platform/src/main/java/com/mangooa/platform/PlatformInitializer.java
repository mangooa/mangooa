package com.mangooa.platform;

import com.mangooa.platform.app.AppService;
import com.mangooa.platform.profile.PlatformProfileEntity;
import com.mangooa.platform.profile.PlatformProfileService;
import com.mangooa.platform.tenant.TenantEntity;
import com.mangooa.platform.tenant.TenantService;
import com.mangooa.platform.user.UserEntity;
import com.mangooa.platform.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

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

	@Resource
	private AppService appService;

	@Override
	public void run(ApplicationArguments args) {
		PlatformProperties.Init init = platformProperties.getInit();
		if (!init.isClose()) {
			/*
			 * 1.初始化平台管理员
			 */
			UserEntity admin = userService.init(init);
			/*
			 * 2.初始化平台配置
			 */
			PlatformProfileEntity profile = platformProfileService.init(admin, init);
			/*
			 * 3.初始化平台租户
			 */
			TenantEntity tenant = tenantService.find(admin);
			if (Objects.isNull(tenant)) {
				tenantService.create(admin, admin.getTenant());
			}
		}
	}
}
