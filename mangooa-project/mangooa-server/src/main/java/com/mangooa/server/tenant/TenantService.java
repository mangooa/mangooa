package com.mangooa.server.tenant;

import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface TenantService extends JpaServiceStringId<TenantRepository, TenantEntity> {

	/**
	 * 初始化租户。
	 *
	 * @param properties 服务器应用配置。
	 */
	void init(ServerAppProperties properties);
}
