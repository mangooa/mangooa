package com.mangooa.common.uaa;

/**
 * 统一认证配置。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface UaaProfile {

	/**
	 * 返回服务器域名。
	 * @return
	 */
	String getDomain();

	String getTenant();

	String getAccount();

}
