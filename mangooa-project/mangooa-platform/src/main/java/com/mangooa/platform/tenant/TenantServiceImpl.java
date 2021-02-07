package com.mangooa.platform.tenant;


import com.mangooa.platform.PlatformConstants;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.platform.PlatformProperties;
import com.mangooa.platform.user.UserEntity;
import com.mangooa.platform.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, TenantEntity> implements TenantService {

	@Resource
	private UserService userService;

	@Resource
	private PlatformProperties platformProperties;

	/**
	 * 初始化系统租户。
	 */
	@Override
	public void init() {
		PlatformProperties.Init init = platformProperties.getInit();
		if (!init.isClose()) {
			String tenant = PlatformConstants.INIT_TENANT_NAME;
			if (getDao().countByNameIgnoreCase(tenant) == 0) {
				UserEntity creator = userService.find(PlatformConstants.INIT_ADMIN_ACCOUNT);
				TenantEntity entity = TenantEntity.of(tenant, tenant + init.getDomain());
				save(entity, true, creator);
			}
		}
	}
}
