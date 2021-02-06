package com.mangooa.platform.server;

import com.mangooa.common.platform.server.ServerProfile;
import com.mangooa.data.jpa.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface ServerProfileService extends JpaServiceStringId<ServerProfileRepository, ServerProfileEntity> {

	/**
	 * 初始化服务器配置。
	 *
	 * @return 服务器配置。
	 */
	ServerProfile init();

}
