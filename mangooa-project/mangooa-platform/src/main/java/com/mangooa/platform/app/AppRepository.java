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

}
