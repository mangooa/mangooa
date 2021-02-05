package com.mangooa.uaa.tenant;


import com.mangooa.common.uaa.UaaInitConstants;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.uaa.user.User;
import com.mangooa.uaa.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, Tenant> implements TenantService {

	@Resource
	private UserService userService;

	/**
	 * 初始化系统租户。
	 */
	@Override
	public void init() {
		String tenant = UaaInitConstants.INIT_TENANT_NAME;
		if (getDao().countByNameIgnoreCase(tenant) == 0) {
			User creator = userService.find(UaaInitConstants.INIT_ADMIN_ACCOUNT);
			Tenant entity = Tenant.of(tenant, tenant + profile.getDomain());
			save(entity, true, creator);
		}
	}
}
