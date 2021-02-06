package com.mangooa.common.platform.security.config;

import com.mangooa.common.platform.security.crypto.bcrypt.BcryptPasswordEncoder;
import com.mangooa.common.platform.security.crypto.password.PasswordEncoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Configuration
@ConditionalOnClass(org.springframework.security.crypto.password.PasswordEncoder.class)
public class SecurityAutoConfigure {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BcryptPasswordEncoder();
	}
}
