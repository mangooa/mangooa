package com.mangooa.common.domain;

import java.io.Serializable;

/**
 * 用户接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface User extends Serializable {

	/**
	 * 获取用户登录租户的名称。
	 *
	 * @return 租户的名称。
	 */
	String getTenant();

	/**
	 * 获取用户的账号。
	 *
	 * @return 用户的账号。
	 */
	String getAccount();

}
