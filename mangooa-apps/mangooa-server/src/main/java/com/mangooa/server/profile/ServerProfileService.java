package com.mangooa.server.profile;

import com.mangooa.common.uaa.User;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface ServerProfileService extends JpaServiceStringId<ServerProfileRepository, ServerProfile> {

	/**
	 * 初始化服务器配置。
	 *
	 * @param properties 服务器应用配置属性。
	 * @param creator    初始化服务器配置创建者。
	 */
	void init(ServerAppProperties properties, User creator);

	/**
	 * 获取服务器配置。
	 *
	 * @return 服务器配置。
	 */
	ServerProfile get();

}
