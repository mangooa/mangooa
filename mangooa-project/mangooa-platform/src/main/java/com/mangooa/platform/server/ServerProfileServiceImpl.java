package com.mangooa.platform.server;

import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.platform.PlatformHelper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class ServerProfileServiceImpl extends BaseJpaServiceStringId<ServerProfileRepository, ServerProfileEntity> implements ServerProfileService {

	@Resource
	private ServerProperties properties;

	@Resource
	private PlatformHelper platform;

	@Override
	public ServerProfileEntity init() {
		ServerProfileEntity profile = getDao().findByNameIgnoreCase(properties.getName().trim());
		if (platform.init()) {
			if (Objects.isNull(profile)) {
				profile = ServerProfileEntity.of(properties);
				profile = save(profile, true, profile);
			}
		}
		return profile;
	}
}
