package com.mangooa.common.platform.user;

import com.mangooa.common.data.DataPermission;

/**
 * 群组接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Group extends DataPermission {

	/**
	 * 返回群组的代码，可用于数据权限控制，例如：HR。
	 *
	 * @return 群组代码。
	 */
	@Override
	String getCode();

	/**
	 * 返回群组的名称，例如：人事部。
	 *
	 * @return 群组名称。
	 */
	String getName();
}
