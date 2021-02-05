package com.mangooa.uaa.server;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一认认证服务器配置。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter(AccessLevel.PRIVATE)
public class ServerProfile {

	/**
	 * 服务器域名。
	 */
	private String domain;

	/**
	 * 服务器账号。
	 */
	private String account;

}
