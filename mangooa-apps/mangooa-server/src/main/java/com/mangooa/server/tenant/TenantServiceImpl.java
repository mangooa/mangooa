package com.mangooa.server.tenant;

import com.mangooa.common.uaa.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.profile.ServerProfile;
import com.mangooa.server.profile.ServerProfileService;

import org.springframework.stereotype.Service;

import static com.mangooa.server.ServerAppConstant.INIT_TENANT_NAME;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, Tenant> implements TenantService {

	private final ServerProfileService serverProfileService;

	public TenantServiceImpl(ServerProfileService serverProfileService) {
		this.serverProfileService = serverProfileService;
	}

	/**
	 * 初始化租户。
	 *
	 * @param properties 服务器应用配置。
	 * @param creator    初始化租户创建者。
	 */
	@Override
	public void init(ServerAppProperties properties, User creator) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable()) {
			ServerProfile profile = serverProfileService.get();
			String tenant = INIT_TENANT_NAME;
			if (getDao().countByNameIgnoreCase(tenant) == 0) {
				Tenant entity = Tenant.of(tenant, tenant + profile.getDomain());
				save(entity, true, creator);
			}
		}
	}
}
