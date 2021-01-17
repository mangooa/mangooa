package com.mangooa.tools.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 用户名密码验证器。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class UserPasswordAuthenticator extends Authenticator {

	/**
	 * 用户名。
	 */
	private final String user;

	/**
	 * 密码。
	 */
	private final String password;

	/**
	 * 构造函数。
	 *
	 * @param user     用户名。
	 * @param password 密码。
	 */
	public UserPasswordAuthenticator(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.user, this.password);
	}
}
