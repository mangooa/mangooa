package com.mangooa.common.dao;

import com.mangooa.common.domain.JpaEntityStringId;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 字符型主键JPA实体对象存储接口。
 *
 * @param <DO> 实体对象类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@NoRepositoryBean
public interface JpaRepositoryStringId<DO extends JpaEntityStringId> extends JpaRepository<DO, String> {
}
