package com.mangooa.uaa.oauth.config;

import com.mangooa.common.spring.security.crypto.bcrypt.BcryptPasswordEncoder;
import com.mangooa.common.spring.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@SuppressWarnings("unused")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 密码编码器。
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BcryptPasswordEncoder();
	}

	/**
	 * 认证管理器。
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) {
		web
			.ignoring()
			.antMatchers("/css/**", "/doc/**", "/img/**", "/js/**", "/favicon.ico");
	}

}
