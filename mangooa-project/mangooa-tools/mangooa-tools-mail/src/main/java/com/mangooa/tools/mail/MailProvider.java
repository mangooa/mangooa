package com.mangooa.tools.mail;

import lombok.Getter;

/**
 * 电子邮件供应商枚举。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
public enum MailProvider {

	/**
	 * QQ邮箱。
	 */
	QQ("QQ邮箱", "QQ_MAIL");

	/**
	 * 邮件供应商名称。
	 */
	private final String name;

	/**
	 * 邮件供应商代码。
	 */
	private final String code;

	MailProvider(String name, String code) {
		this.name = name;
		this.code = code;
	}

	/**
	 * 邮件供应商服务器。
	 */
	public static class Server {

	}

}
