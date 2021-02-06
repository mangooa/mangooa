package com.mangooa.common.platform.server;

import java.io.Serializable;

/**
 * 服务器配置。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface ServerProfile extends Serializable {

	/**
	 * 返回服务器账号。
	 *
	 * @return 服务器账号。
	 */
	String getAccount();

	/**
	 * 返回服务器域名，如：.mangooa.com。
	 *
	 * @return 服务器域名。
	 */
	String getDomain();

	/**
	 * 返回服务所属租户。
	 *
	 * @return 服务所属租户。
	 */
	String getTenant();
}
