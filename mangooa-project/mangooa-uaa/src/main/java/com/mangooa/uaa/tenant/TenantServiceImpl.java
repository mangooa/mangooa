package com.mangooa.uaa.tenant;


import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.uaa.user.User;
import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, Tenant> implements TenantService {


	/**
	 * 初始化租户。
	 */
	@Override
	public void init() {
//		ServerAppProperties.Init init = properties.getInit();
//		if (init.isEnable()) {
//			ServerProfile profile = serverProfileService.get();
//			String tenant = INIT_TENANT_NAME;
//			if (getDao().countByNameIgnoreCase(tenant) == 0) {
//				Tenant entity = Tenant.of(tenant, tenant + profile.getDomain());
//				save(entity, true, creator);
//			}
//		}
	}
}
