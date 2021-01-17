package com.mangooa.data.jpa;

import com.mangooa.common.data.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 字符型主键JPA实体对象存储接口。
 *
 * @param <DO> 实体对象类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@NoRepositoryBean
public interface JpaRepositoryStringId<DO extends BaseJpaEntityStringId> extends Dao<DO, String>, JpaRepository<DO, String> {

}
