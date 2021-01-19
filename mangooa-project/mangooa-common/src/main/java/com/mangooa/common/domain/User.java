package com.mangooa.common.domain;

/**
 * 用户接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface User {

	/**
	 * 获取用户登录的租户。
	 *
	 * @return 登录的租户。
	 */
	String getTenant();

	/**
	 * 获取用户账号。
	 *
	 * @return 用户账号。
	 */
	String getAccount();

	/**
	 * 获取用户姓名。
	 *
	 * @return 用户账号。
	 */
	String getName();

}
