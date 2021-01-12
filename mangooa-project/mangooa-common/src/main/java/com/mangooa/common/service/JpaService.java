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
public interface JpaService<DAO extends JpaRepository<DO, ID>, DO extends JpaEntity<ID>, ID extends Serializable> extends Service<DAO, DO, ID> {
}
