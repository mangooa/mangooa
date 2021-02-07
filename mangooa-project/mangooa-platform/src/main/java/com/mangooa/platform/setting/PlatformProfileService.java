package com.mangooa.platform.setting;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.platform.PlatformProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface PlatformProfileService extends JpaServiceStringId<PlatformProfileRepository, PlatformProfileEntity> {

	/**
	 * 初始化平台。
	 *
	 * @param creator 平台初始化配置用户。
	 * @param init    平台初始化配置。
	 * @return 平台实体对象。
	 */
	PlatformProfileEntity init(User creator, PlatformProperties.Init init);
}
