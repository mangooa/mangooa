package com.mangooa.server.profile;

import com.mangooa.common.domain.Editor;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import static com.mangooa.server.ServerAppConstant.INIT_ADMIN_ACCOUNT;
import static com.mangooa.server.ServerAppConstant.INIT_TENANT_NAME;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class ServerProfileServiceImpl extends BaseJpaServiceStringId<ServerProfileRepository, ServerProfileEntity> implements ServerProfileService {

	/**
	 * 初始化服务器配置。
	 *
	 * @param properties 服务器应用配置属性。
	 */
	@Override
	public void init(ServerAppProperties properties) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable() && getDao().count() == 0) {
			String domain = init.getDomain().trim().toLowerCase();
			Editor creator = Editor.of(INIT_TENANT_NAME, INIT_ADMIN_ACCOUNT, "管理员");
			ServerProfileEntity entity = ServerProfileEntity.of(domain);
			save(creator, entity, true);
		}
	}

	/**
	 * 获取服务器配置。
	 *
	 * @return 服务器配置。
	 */
	@Override
	public ServerProfileEntity get() {
		return getDao().findAll().get(0);
	}

}
