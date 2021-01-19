package com.mangooa.data.jpa;

import com.mangooa.common.data.Service;
import com.mangooa.common.domain.Editor;


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
	 * @param editor 实体创建者。
	 * @param entity 实体对象。
	 * @param flush  真表示立即提交。
	 * @return 实体对象。
	 */
	DO save(Editor editor, DO entity, boolean flush);

	/**
	 * 编号保存实体。
	 *
	 * @param editor 实体更新者。
	 * @param entity 实体对象。
	 * @param flush  真表示立即提交。
	 * @return 实体对象。
	 */
	DO update(Editor editor, DO entity, boolean flush);
}
