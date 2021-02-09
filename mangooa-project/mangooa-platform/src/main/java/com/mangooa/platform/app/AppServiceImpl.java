package com.mangooa.platform.app;

import com.mangooa.common.platform.app.AppType;
import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.platform.PlatformConstants;
import com.mangooa.tools.core.lang.StringUtils;
import com.mangooa.tools.crypto.digest.DigestUtils;
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
		if (PlatformConstants.TENANT_NAME.equalsIgnoreCase(name)) {
			entity.setClientId(DigestUtils.md5Hex(name));
		}
		entity = save(creator, entity, true);
		return entity;
	}
}
