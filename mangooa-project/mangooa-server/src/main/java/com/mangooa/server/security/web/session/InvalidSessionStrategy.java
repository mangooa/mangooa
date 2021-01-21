package com.mangooa.server.security.web.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class InvalidSessionStrategy implements org.springframework.security.web.session.InvalidSessionStrategy {
	@Override
	public void onInvalidSessionDetected(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
		System.out.println("调用InvalidSessionStrategy.onInvalidSessionDetected");
	}
}
