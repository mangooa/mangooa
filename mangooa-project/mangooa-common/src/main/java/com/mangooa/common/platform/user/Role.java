package com.mangooa.common.platform.user;

import com.mangooa.common.data.DataPermission;

/**
 * 角色接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Role extends DataPermission {

	/**
	 * 返回角色的代码（大写），用于数据权限控制创建后不可以修改，例如：ADMIN。
	 *
	 * @return 角色代码。
	 */
	@Override
	String getCode();

	/**
	 * 返回角色的名称，例如：管理员。
	 *
	 * @return 角色名称。
	 */
	String getName();

}
