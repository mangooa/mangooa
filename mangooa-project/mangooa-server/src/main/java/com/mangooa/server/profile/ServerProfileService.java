package com.mangooa.server.profile;

import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface ServerProfileService extends JpaServiceStringId<ServerProfileRepository, ServerProfileEntity> {

	/**
	 * 初始化服务器配置。
	 *
	 * @param properties 服务器应用配置属性。
	 */
	void init(ServerAppProperties properties);

	/**
	 * 获取服务器配置。
	 *
	 * @return 服务器配置。
	 */
	ServerProfileEntity get();

}
