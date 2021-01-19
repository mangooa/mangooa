package com.mangooa.uaaa.domain;

/**
 * 用户。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface User extends com.mangooa.common.security.domain.User {

	/**
	 * 获取用户手机号。
	 *
	 * @return 用户手机号。
	 */
	String getCellphone();

}
