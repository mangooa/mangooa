package com.mangooa.common.security.domain;

/**
 * 用户接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface User {

	/**
	 * 获取用户登录租户的名称。
	 *
	 * @return 用户登录租户的名称。
	 */
	String getTenant();

	/**
	 * 获取用户的账号，创建后不可修改。
	 *
	 * @return 用户的账号。
	 */
	String getAccount();

}
