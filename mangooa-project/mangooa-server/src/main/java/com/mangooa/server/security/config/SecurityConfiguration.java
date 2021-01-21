package com.mangooa.server.security.config;

import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.security.core.userdetails.UserDetailsServiceImpl;

import com.mangooa.server.security.web.AuthenticationEntryPoint;
import com.mangooa.server.security.web.access.AccessDeniedHandler;
import com.mangooa.server.security.web.authentication.AuthenticationFailureHandler;
import com.mangooa.server.security.web.authentication.AuthenticationSuccessHandler;
import com.mangooa.server.security.web.authentication.logout.LogoutHandler;
import com.mangooa.server.security.web.authentication.logout.LogoutSuccessHandler;
import com.mangooa.server.security.web.session.InvalidSessionStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.session.FindByIndexNameSessionRepository;
//import org.springframework.session.Session;
//import org.springframework.session.security.SpringSessionBackedSessionRegistry;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@EnableWebSecurity
@SuppressWarnings("unused")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final ServerAppProperties properties;
	private final UserDetailsServiceImpl userDetailsService;
//	private final FindByIndexNameSessionRepository<S> sessionRepository;

	public SecurityConfiguration(ServerAppProperties properties, UserDetailsServiceImpl userDetailsService) {
		this.properties = properties;
		this.userDetailsService = userDetailsService;
//		this.sessionRepository = sessionRepository;
	}

//	@Bean
//	public SpringSessionBackedSessionRegistry<S> sessionRegistry() {
//		return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.debug(true)
			.ignoring()
			.antMatchers("/account/**")
			.antMatchers("/css/**", "/doc/**", "/img/**", "/js/**", "favicon.ico");
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);

//		http
//			.sessionManagement()
//			.maximumSessions(1)
//			.sessionRegistry(sessionRegistry());
//		http.sessionManagement((sessionManagement) -> sessionManagement
//			//.invalidSessionStrategy(new InvalidSessionStrategy())
//			.sessionFixation()
//			.migrateSession()
//			.maximumSessions(1)
//			.sessionRegistry(sessionRegistry())
//		);
//		http.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/account/login")
//			.loginProcessingUrl("/account/login")
//			.usernameParameter("username")
//			.passwordParameter("password")
////			.successHandler(new AuthenticationSuccessHandler())
////			.failureHandler(new AuthenticationFailureHandler())
//			.permitAll()
//			.and()
//			.logout()
//			.logoutUrl("/logout")
//			.deleteCookies(properties.getSessionCookieName())
//			.clearAuthentication(true)
//			.invalidateHttpSession(true)
////			.addLogoutHandler(new LogoutHandler())
////			.logoutSuccessHandler(new LogoutSuccessHandler())
//			.permitAll()
//			.and()
////			.exceptionHandling()
////			.accessDeniedHandler(new AccessDeniedHandler())
////			.authenticationEntryPoint(new AuthenticationEntryPoint())
////			.and()
//		http
//			.csrf()
//			.disable()
//			.cors();
//	}

}
