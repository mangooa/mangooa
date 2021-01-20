package com.mangooa.server.security.config;

import com.mangooa.server.security.core.userdetails.UserDetailsServiceImpl;

import com.mangooa.server.security.web.authentication.logout.LogoutHandler;
import com.mangooa.server.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Configuration
@SuppressWarnings("unused")
public class SecurityConfiguration<S extends Session> extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;

	private final FindByIndexNameSessionRepository<S> sessionRepository;

	public SecurityConfiguration(UserDetailsServiceImpl userDetailsService, FindByIndexNameSessionRepository<S> sessionRepository) {
		this.userDetailsService = userDetailsService;
		this.sessionRepository = sessionRepository;
	}

	@Bean
	public SpringSessionBackedSessionRegistry<S> sessionRegistry() {
		return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/login", "/logout")
			.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
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
//				.logoutUrl("/logout")
//				.deleteCookies("JSESSIONID")
//				.clearAuthentication(true)
//				.invalidateHttpSession(true)
//				.addLogoutHandler(new LogoutHandler())
//				.logoutSuccessHandler(new LogoutSuccessHandler())
//				.permitAll()
//			.and()
//			.exceptionHandling()
//			.accessDeniedHandler(new AccessDeniedHandler())
//			.authenticationEntryPoint(new AuthenticationEntryPoint())
			.and()
			.sessionManagement((sessionManagement) -> sessionManagement
				.invalidSessionUrl("/invalid-session.html")
				.sessionFixation()
				.migrateSession()
				.maximumSessions(1)
				.sessionRegistry(sessionRegistry())
			)
			.csrf()
			.disable()
			.cors();
	}
}
