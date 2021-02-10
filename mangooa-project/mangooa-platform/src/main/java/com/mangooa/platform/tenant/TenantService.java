package com.mangooa.platform.tenant;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface TenantService extends JpaServiceStringId<TenantRepository, TenantEntity> {

	/**
	 * 新建租户。
	 *
	 * @param creator 创建者（租户所属用户）。
	 * @param name    租户名称。
	 * @return 租户实体对象。
	 * @throws TenantNameExistsException 如果租户名称已存在时。
	 */
	TenantEntity create(User creator, String name) throws TenantNameExistsException;

	/**
	 * 查找给定用户登陆的租户，如果找不到返回{@code null}。
	 *
	 * @param user 用户。
	 * @return 租户实体。
	 */
	TenantEntity find(User user);
}
