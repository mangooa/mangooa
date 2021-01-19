package com.mangooa.server.name.user;

/**
 * 用户已存在异常。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class UserEmailExistedException extends RuntimeException {

	private static final long serialVersionUID = -4797774298926611468L;

	public UserEmailExistedException(String message) {
		super(message);
	}
}
