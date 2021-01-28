package com.mangooa.server.security.config;

import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.security.core.userdetails.UserDetailsService;
import com.mangooa.server.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@EnableWebSecurity
@Slf4j
@SuppressWarnings("unused")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private ServerAppProperties properties;

	@Resource
	private UserDetailsService userDetailsService;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(WebSecurity web) {
		web
			.debug(true)
			.ignoring()
			.antMatchers("/css/**", "/doc/**", "/img/**", "/js/**", "/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests(requests -> requests
			.anyRequest().authenticated()
		);

		http.formLogin(login -> login
			.usernameParameter("username")
			.passwordParameter("password")
			.loginPage("/account/login")
			.loginProcessingUrl("/account/login")
			.successForwardUrl("http://www.baidu.com")
			.failureForwardUrl("/account/login?error=true")
			.permitAll()
		);

		http.logout(logout -> logout
			.logoutUrl("/account/logout")
			.permitAll()
		);

	}
}
