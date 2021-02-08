package com.mangooa.platform.tenant;

import com.mangooa.data.jpa.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface TenantService extends JpaServiceStringId<TenantRepository, TenantEntity> {

	/**
	 * 初始化系统租户。
	 */
	void init();
}
