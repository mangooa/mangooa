package com.mangooa.server.security.config;

import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.security.core.userdetails.UserDetailsService;
import com.mangooa.server.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
@SuppressWarnings("unused")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Resource
	private ServerAppProperties properties;

	@Resource
	private UserDetailsService userDetailsService;

	@Resource
	private PasswordEncoder passwordEncoder;

//	@Resource
//	private FindByIndexNameSessionRepository<S> sessionRepository;
//
//	@Bean
//	public SpringSessionBackedSessionRegistry<S> sessionRegistry() {
//		return new SpringSessionBackedSessionRegistry<>(this.sessionRepository);
//	}

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
			//.antMatchers("/account/**").permitAll()
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

		http.logout(logout->logout
			.logoutUrl("/account/logout")
			.permitAll()
		);
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
