package com.mangooa.server.profile;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class ServerProfileServiceImpl extends BaseJpaServiceStringId<ServerProfileRepository, ServerProfile> implements ServerProfileService {

	/**
	 * 初始化服务器配置。
	 *
	 * @param properties 服务器应用配置属性。
	 * @param creator    初始化服务器配置创建者。
	 */
	@Override
	public void init(ServerAppProperties properties, User creator) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable() && getDao().count() == 0) {
			String domain = init.getDomain().trim().toLowerCase();
			ServerProfile entity = ServerProfile.of(domain);
			save(entity, true, creator);
		}
	}

	/**
	 * 获取服务器配置。
	 *
	 * @return 服务器配置。
	 */
	@Override
	public ServerProfile get() {
		return getDao().findAll().get(0);
	}

}
