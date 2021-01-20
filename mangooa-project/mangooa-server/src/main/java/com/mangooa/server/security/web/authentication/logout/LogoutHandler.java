package com.mangooa.server.security.web.authentication.logout;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class LogoutHandler implements org.springframework.security.web.authentication.logout.LogoutHandler {

	@Override
	public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

	}
}
