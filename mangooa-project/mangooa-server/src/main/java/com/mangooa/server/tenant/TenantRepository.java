package com.mangooa.server.tenant;

import com.mangooa.data.jpa.JpaRepositoryStringId;
import org.springframework.stereotype.Repository;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Repository
public interface TenantRepository extends JpaRepositoryStringId<TenantEntity> {

	/**
	 * 根据给定的租户名称查找对应租户实体的数量，如果找不到则返回零。
	 *
	 * @param name 给定的租户名称，忽略大小写。
	 * @return 租户实体的数量。
	 */
	long countByNameIgnoreCase(String name);
}
