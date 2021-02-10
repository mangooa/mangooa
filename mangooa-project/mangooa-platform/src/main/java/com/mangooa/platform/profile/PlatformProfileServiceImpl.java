package com.mangooa.platform.profile;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;
import com.mangooa.platform.PlatformInitializationException;
import com.mangooa.platform.PlatformProperties;
import com.mangooa.tools.core.lang.StringUtils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Slf4j
@Service
public class PlatformProfileServiceImpl extends BaseJpaServiceStringId<PlatformProfileRepository, PlatformProfileEntity> implements PlatformProfileService {

	@Override
	public PlatformProfileEntity getPlatformProfile() {
		List<PlatformProfileEntity> profiles = getDao().findAll();
		long size = profiles.size();
		if (size > 1) {
			throw new IllegalStateException("Found multiple platform profile.");
		} else {
			if (size == 0) {
				throw new PlatformProfileNotExistException();
			}
		}
		return profiles.get(0);
	}

	@Override
	public PlatformProfileEntity init(User admin, PlatformProperties.Init init) {
		PlatformProfileEntity profile = null;
		try {
			profile = getPlatformProfile();
		} catch (PlatformProfileNotExistException e) {
			// 忽略
		}
		if (!init.isClose() && Objects.isNull(profile)) {
			String domain = StringUtils.toLowerCaseAndTrim(init.getDomain());
			if (StringUtils.isBlank(domain)) {
				throw new PlatformInitializationException("Domain name configuration cannot be empty.");
			}
			profile = PlatformProfileEntity.of(domain);
			profile = save(admin, profile, true);
		}
		return profile;
	}
}
