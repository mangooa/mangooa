package com.mangooa.server.app;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface AppRepository extends JpaRepositoryStringId<App> {

	/**
	 * 根据给定的应用名称查找指定租户下对应的应用实体，如果找不到则返回{@code null}。
	 *
	 * @param name   给定的应用名称，忽略大小写。
	 * @param tenant 指定租户的名称，忽略大小写。
	 * @return 应用实体对象。
	 */
	App findByNameIgnoreCaseAndTenantIgnoreCase(String name, String tenant);

	/**
	 * 根据给定的应用名称查找指定租户下对应应用实体的数量，如果找不到则返回零。
	 *
	 * @param name   给定的应用名称。
	 * @param tenant 指定租户的名称。
	 * @return 应用实体的数量。
	 */
	long countByNameIgnoreCaseAndTenantIgnoreCase(String name,String tenant);

}
