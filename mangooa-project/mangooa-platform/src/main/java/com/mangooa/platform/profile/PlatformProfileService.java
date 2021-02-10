package com.mangooa.platform.profile;

import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.platform.PlatformProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface PlatformProfileService extends JpaServiceStringId<PlatformProfileRepository, PlatformProfileEntity> {

	/**
	 * 返回平台配置。
	 *
	 * @return 平台配置实体对象。
	 * @throws PlatformProfileNotExistException 如果平台配置文件不存在时。
	 */
	PlatformProfileEntity getPlatformProfile() throws PlatformProfileNotExistException;


	/**
	 * 初始化平台配置。
	 *
	 * @param admin 平台管理员。
	 * @param init  平台初始化配置。
	 */
	PlatformProfileEntity init(User admin, PlatformProperties.Init init);
}
