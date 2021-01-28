package com.mangooa.uaa.tenant;

import com.mangooa.data.jpa.JpaServiceStringId;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface TenantService extends JpaServiceStringId<TenantRepository, Tenant> {

//	/**
//	 * 初始化租户。
//	 *
//	 * @param properties 服务器应用配置。
//	 * @param creator    初始化租户创建者。
//	 */
//	void init(ServerAppProperties properties, User creator);
}
