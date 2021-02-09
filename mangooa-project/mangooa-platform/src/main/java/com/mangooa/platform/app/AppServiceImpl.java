package com.mangooa.platform.app;

import com.mangooa.common.platform.app.AppType;
import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import org.springframework.stereotype.Service;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class AppServiceImpl extends BaseJpaServiceStringId<AppRepository, AppEntity> implements AppService {

	@Override
	public AppEntity create(User creator, AppType type, String name, String title) throws AppNameExistsException {
		if (getDao().countByNameIgnoreCase(name) != 0) {
			throw new AppNameExistsException(name);
		}
		AppEntity entity = AppEntity.of(type, name, title);
		entity = save(creator, entity, true);
		return entity;
	}
}
