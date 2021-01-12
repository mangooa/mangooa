package com.mangooa.common.service;

import com.mangooa.common.dao.JpaRepositoryStringId;
import com.mangooa.common.domain.BaseJpaEntityStringId;

/**
 * 字符型主键JPA实体数据服务接口。
 *
 * @param <DAO> 实体数据访问对象类型。
 * @param <DO>  实体数据对象类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface JpaServiceStringId<DAO extends JpaRepositoryStringId<DO>, DO extends BaseJpaEntityStringId> extends JpaService<DAO, DO, String> {
}
