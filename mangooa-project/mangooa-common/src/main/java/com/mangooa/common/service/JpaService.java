package com.mangooa.common.service;

import com.mangooa.common.dao.JpaRepository;
import com.mangooa.common.domain.JpaEntity;

import java.io.Serializable;

/**
 * JPA实体数据服务接口。
 *
 * @param <DAO> 实体数据访问对象类型。
 * @param <DO>  实体数据对象类型。
 * @param <ID>  实体数据主键类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface JpaService<DAO extends JpaRepository<DO, ID>, DO extends JpaEntity<ID>, ID extends Serializable> extends Service<DAO, DO, ID> {

	/**
	 * 新建保存实体。
	 *
	 * @param entity 实体对象。
	 * @return 实体对象。
	 */
	@Override
	default DO save(DO entity) {
		return save(entity, false);
	}

	/**
	 * 新建保存实体。
	 *
	 * @param entity 实体对象。
	 * @param flush  真表示立即提交。
	 * @return 实体对象。
	 */
	default DO save(DO entity, boolean flush) {
		if (entity.isSaved()) {
			throw new IllegalStateException("entity has been saved,please call update method.");
		}
		return (!flush) ? getDao().save(entity) : getDao().saveAndFlush(entity);
	}

	/**
	 * 编号保存实体。
	 *
	 * @param entity 实体对象。
	 * @param flush  真表示立即提交。
	 * @return 实体对象。
	 */
	default DO update(DO entity, boolean flush) {
		if (!entity.isSaved()) {
			throw new IllegalStateException("entity has not been saved,please call save method.");
		}
		return (!flush) ? getDao().save(entity) : getDao().saveAndFlush(entity);
	}

	/**
	 * 编号保存实体。
	 *
	 * @param entity 实体对象。
	 * @return 实体对象。
	 */
	@Override
	default DO update(DO entity) {
		return update(entity, false);
	}
}
