package com.mangooa.common.dao;

import com.mangooa.common.domain.JpaEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * JPA实体对象存储接口。
 *
 * @param <DO> 实体对象类型。
 * @param <ID> 实体对象主键类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@NoRepositoryBean
public interface JpaRepository<DO extends JpaEntity<ID>, ID extends Serializable> extends Dao<DO, ID>, org.springframework.data.jpa.repository.JpaRepository<DO, ID> {

}
