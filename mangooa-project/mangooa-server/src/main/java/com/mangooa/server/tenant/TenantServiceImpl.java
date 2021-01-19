package com.mangooa.server.tenant;

import com.mangooa.common.domain.Editor;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.server.ServerAppProperties;
import com.mangooa.server.profile.ServerProfileEntity;
import com.mangooa.server.profile.ServerProfileService;

import org.springframework.stereotype.Service;

import static com.mangooa.server.ServerAppConstant.INIT_ADMIN_ACCOUNT;
import static com.mangooa.server.ServerAppConstant.INIT_TENANT_NAME;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, TenantEntity> implements TenantService {

	private final ServerProfileService serverProfileService;

	public TenantServiceImpl(ServerProfileService serverProfileService) {
		this.serverProfileService = serverProfileService;
	}

	@Override
	public void init(ServerAppProperties properties) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable()) {
			ServerProfileEntity profile = serverProfileService.get();
			String tenant = INIT_TENANT_NAME;
			if (getDao().countByNameIgnoreCase(tenant) == 0) {
				Editor creator = Editor.of(tenant, INIT_ADMIN_ACCOUNT, "管理员");
				TenantEntity entity = TenantEntity.of(tenant, tenant + profile.getDomain());
				save(creator, entity, true);
			}
		}
	}
}
