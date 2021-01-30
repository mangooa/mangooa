package com.mangooa.common.uaa;

import com.mangooa.common.data.DataPermission;

/**
 * 用户接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface User extends DataPermission {

	/**
	 * 返回当用户登录的租户。
	 *
	 * @return 租户名称。
	 */
	String getTenant();

	/**
	 * 返回用户的账号，创建后不可以修改。
	 *
	 * @return 用户账号。
	 */
	String getAccount();

	/**
	 * 返回用户的账号，用于数据权限控制，例如：ADMIN。
	 *
	 * @return 用户账号。
	 */
	@Override
	default String getCode() {
		return getAccount().toUpperCase();
	}

}
