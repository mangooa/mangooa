package com.mangooa.data.jpa;

import com.mangooa.common.service.Service;
import com.mangooa.common.platform.user.User;


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
	 * @param creator 实体对象创建者。
	 * @param entity  实体对象。
	 * @param flush   真表示立即提交。
	 * @return 实体对象。
	 */
	DO save(User creator, DO entity, boolean flush);

	/**
	 * 编号保存实体。
	 *
	 * @param updator 实体对象更新者。
	 * @param entity  实体对象。
	 * @param flush   真表示立即提交。
	 * @return 实体对象。
	 */
	DO update(User updator, DO entity, boolean flush);
}
