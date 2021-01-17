package com.mangooa.data.jpa;

import com.mangooa.common.data.Service;
import com.mangooa.common.domain.Editor;
import com.mangooa.tools.core.date.SystemClock;

import java.util.Date;


/**
 * 字符型主键JPA实体数据服务接口。
 *
 * @param <DAO> 实体数据访问对象类型。
 * @param <DO>  实体数据对象类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface JpaServiceStringId<DAO extends JpaRepositoryStringId<DO>, DO extends BaseJpaEntityStringId> extends Service<DAO, DO, String> {

	/**
	 * 新建保存实体。
	 *
	 * @param entity 实体对象。
	 * @param editor 实体创建者。
	 * @return 实体对象。
	 */
	@Override
	default DO save(Editor editor, DO entity) {
		return save(editor, entity, false);
	}

	/**
	 * 新建保存实体。
	 *
	 * @param editor 实体创建者。
	 * @param entity 实体对象。
	 * @param flush  真表示立即提交。
	 * @return 实体对象。
	 */
	default DO save(Editor editor, DO entity, boolean flush) {
		if (entity.isSaved()) {
			throw new IllegalStateException("entity has been saved,please call update method.");
		}
		Date now = new Date(SystemClock.now());
		entity.setCreateTime(now);
		entity.setCreator(editor);
		entity.setUpdateTime(now);
		entity.setUpdator(editor);
		return (!flush) ? getDao().save(entity) : getDao().saveAndFlush(entity);
	}

	/**
	 * 编号保存实体。
	 *
	 * @param editor 实体更新者。
	 * @param entity 实体对象。
	 * @param flush  真表示立即提交。
	 * @return 实体对象。
	 */
	default DO update(Editor editor, DO entity, boolean flush) {
		if (!entity.isSaved()) {
			throw new IllegalStateException("entity has not been saved,please call save method.");
		}
		Date now = new Date(SystemClock.now());
		entity.setUpdateTime(now);
		entity.setUpdator(editor);
		return (!flush) ? getDao().save(entity) : getDao().saveAndFlush(entity);
	}

	/**
	 * 编号保存实体。
	 *
	 * @param editor 实体更新者。
	 * @param entity 实体对象。
	 * @return 实体对象。
	 */
	@Override
	default DO update(Editor editor, DO entity) {
		return update(editor, entity, false);
	}
}
