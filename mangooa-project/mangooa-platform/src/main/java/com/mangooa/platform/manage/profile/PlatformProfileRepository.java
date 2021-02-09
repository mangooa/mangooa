package com.mangooa.platform.manage.profile;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface PlatformProfileRepository extends JpaRepositoryStringId<PlatformProfileEntity> {

	/**
	 * 根据域名查找对应的平台配置。
	 *
	 * @param domain 域名忽略大小写。
	 * @return 平台配置实体对象。
	 */
	PlatformProfileEntity findByDomainIgnoreCase(String domain);
}
