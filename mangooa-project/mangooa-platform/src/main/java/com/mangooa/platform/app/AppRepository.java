package com.mangooa.platform.app;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface AppRepository extends JpaRepositoryStringId<AppEntity> {

	/**
	 * 根据给定的名称查找对应实体的数量。
	 *
	 * @param name 应用名称。
	 * @return 应用实体的数量。
	 */
	long countByNameIgnoreCase(String name);

	/**
	 * 根据给定的租户及应用名称查找对应的应用实体，如果找不到返回{@code null}。
	 *
	 * @param tenant 租户名称。
	 * @param name   应用名称。
	 * @return 应用实体对象。
	 */
	AppEntity findByTenantIgnoreCaseAndNameIgnoreCase(String tenant, String name);

}
