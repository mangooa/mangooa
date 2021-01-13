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
