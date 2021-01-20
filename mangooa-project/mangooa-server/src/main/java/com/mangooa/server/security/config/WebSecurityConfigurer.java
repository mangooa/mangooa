package com.mangooa.server.security.config;

import com.mangooa.server.security.core.userdetails.UserDetailsServiceImpl;
import com.mangooa.server.security.web.AuthenticationEntryPoint;
import com.mangooa.server.security.web.access.AccessDeniedHandler;
import com.mangooa.server.security.web.authentication.AuthenticationFailureHandler;

import com.mangooa.server.security.web.authentication.AuthenticationSuccessHandler;
import com.mangooa.server.security.web.authentication.logout.LogoutHandler;
import com.mangooa.server.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Configuration
@SuppressWarnings("unused")
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;

	public WebSecurityConfigurer(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/login", "/logout");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.usernameParameter("username")
			.passwordParameter("password")
//			.successHandler(new AuthenticationSuccessHandler())
//			.failureHandler(new AuthenticationFailureHandler())
//			.permitAll()
//			.and()
//			.logout()
//			.logoutUrl("/logout")
//			.clearAuthentication(true)
//			.invalidateHttpSession(true)
//			.addLogoutHandler(new LogoutHandler())
//			.logoutSuccessHandler(new LogoutSuccessHandler())
//			.permitAll()
//			.and()
//			.exceptionHandling()
//			.accessDeniedHandler(new AccessDeniedHandler())
//			.authenticationEntryPoint(new AuthenticationEntryPoint())
			.and()
			.csrf()
			.disable()
			.cors();
	}
}
