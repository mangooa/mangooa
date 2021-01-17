package com.mangooa.server.uaaa.user;

import com.mangooa.common.security.crypto.password.PasswordEncoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 用户密码加密器。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Component
public final class UserPasswordEncoder implements PasswordEncoder {

	private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Override
	public String encode(CharSequence rawPassword) {
		return ENCODER.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return ENCODER.matches(rawPassword, encodedPassword);
	}
}
