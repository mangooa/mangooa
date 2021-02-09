package com.mangooa.platform.user;

/**
 * 用户已存在异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class UserEmailExistsException extends RuntimeException {

	private static final long serialVersionUID = -4797774298926611468L;

	UserEmailExistsException(String email) {
		super(email);
	}
}
