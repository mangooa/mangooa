package com.mangooa.common.service.impl;

import com.mangooa.common.dao.JpaRepository;
import com.mangooa.common.domain.JpaEntity;
import com.mangooa.common.service.JpaService;

import java.io.Serializable;

/**
 * JPA实体数据服务接口实现类。
 *
 * @param <DAO> 实体数据访问对象类型。
 * @param <DO>  实体数据对象类型。
 * @param <ID>  实体数据主键类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public abstract class BaseJpaService<DAO extends JpaRepository<DO, ID>, DO extends JpaEntity<ID>, ID extends Serializable> extends BaseService<DAO, DO, ID> implements JpaService<DAO, DO, ID> {

}
