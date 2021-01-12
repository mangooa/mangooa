package com.mangooa.common.service.impl;

import com.mangooa.common.dao.JpaRepositoryStringId;
import com.mangooa.common.domain.BaseJpaEntityStringId;
import com.mangooa.common.service.JpaServiceStringId;

/**
 * 字符型主键JPA实体数据服务接口实现类。
 *
 * @param <DAO> 实体数据访问对象类型。
 * @param <DO>  实体数据对象类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public abstract class BaseJpaServiceStringId<DAO extends JpaRepositoryStringId<DO>, DO extends BaseJpaEntityStringId> extends BaseJpaService<DAO, DO, String> implements JpaServiceStringId<DAO, DO> {
}
