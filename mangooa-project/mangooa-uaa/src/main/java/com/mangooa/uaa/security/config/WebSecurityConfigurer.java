package com.mangooa.uaa.security.config;

import com.mangooa.common.spring.security.crypto.bcrypt.BcryptPasswordEncoder;
import com.mangooa.common.spring.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@SuppressWarnings("unused")
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

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
			.debug(false)
			.ignoring()
			.antMatchers("/css/**", "/doc/**", "/img/**", "/js/**", "/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 授权请求配置
		http
			.authorizeRequests(requests -> requests
				.antMatchers(HttpMethod.GET, "/oauth/authorize").permitAll()
				.anyRequest().permitAll()
			);
		// 会话管理配置
		http
			.sessionManagement(management -> management
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			);
		// 表单登录配置
		http
			.formLogin(login -> login
				.loginPage("/login")
			);
		// 会话登出配置
		http
			.logout(logout -> logout
				.logoutUrl("/logout")
			);

		http
			.csrf().disable();
	}
}