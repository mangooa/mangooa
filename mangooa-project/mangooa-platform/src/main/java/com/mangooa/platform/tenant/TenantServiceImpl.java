package com.mangooa.platform.tenant;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.platform.profile.PlatformProfileEntity;
import com.mangooa.platform.profile.PlatformProfileService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class TenantServiceImpl extends BaseJpaServiceStringId<TenantRepository, TenantEntity> implements TenantService {

	@Resource
	private PlatformProfileService platformProfileService;

	@Override
	public TenantEntity create(User creator, String name) throws TenantNameExistsException {
		if (getDao().countByNameIgnoreCase(name) != 0) {
			throw new TenantNameExistsException(name);
		}
		PlatformProfileEntity profile = platformProfileService.getPlatformProfile();
		TenantEntity entity = TenantEntity.of(name, profile.getDomain());
		entity = save(creator, entity);
		return entity;
	}

	@Override
	public TenantEntity find(User user) {
		return getDao().findByNameIgnoreCase(user.getTenant());
	}
}
