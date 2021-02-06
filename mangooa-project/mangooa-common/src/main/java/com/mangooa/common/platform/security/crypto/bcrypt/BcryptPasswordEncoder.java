package com.mangooa.common.platform.security.crypto.bcrypt;

import com.mangooa.common.platform.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public class BcryptPasswordEncoder implements PasswordEncoder {

	private final BCryptPasswordEncoder passwordEncoder;

	public BcryptPasswordEncoder() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
}
