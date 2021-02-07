package com.mangooa.platform;

import com.mangooa.platform.setting.PlatformProfileService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Component
public class PlatformInitializer implements ApplicationRunner {

	@Resource
	private PlatformProperties platformProperties;

	@Resource
	private PlatformProfileService platformService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
