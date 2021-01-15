package com.mangooa.common.domain;

import java.io.Serializable;

/**
 * JPA实体接口。
 *
 * @param <ID> 实体主键类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface JpaEntity<ID extends Serializable> extends DataObject<ID> {

	/**
	 * 返回真表示实体还为保存过。
	 *
	 * @return 真表示实体还为保存过。
	 */
	boolean isSaved();
}
