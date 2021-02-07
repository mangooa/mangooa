package com.mangooa.platform.setting;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.platform.PlatformProperties;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class PlatformProfileServiceImpl extends BaseJpaServiceStringId<PlatformProfileRepository, PlatformProfileEntity> implements PlatformProfileService {

	@Override
	public PlatformProfileEntity init(User creator, PlatformProperties.Init init) {
		String domain = init.getDomain().trim().toLowerCase();
		PlatformProfileEntity ret = getDao().findByDomainIgnoreCase(domain);
		if (Objects.isNull(ret)) {
			ret = new PlatformProfileEntity();
			ret.setDomain(domain);
			ret = save(creator, ret, true);
		}
		return ret;
	}
}
