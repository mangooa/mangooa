package com.mangooa.platform.server;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface ServerProfileRepository extends JpaRepositoryStringId<ServerProfileEntity> {

	/**
	 * 根据服务器名称查找对应的服务器配置。
	 *
	 * @param name 服务器名称，忽略大写小。
	 * @return 服务器配置。
	 */
	ServerProfileEntity findByNameIgnoreCase(String name);

}
