package com.mangooa.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体接口。
 *
 * @param <ID> 实体主键类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Entity<ID extends Serializable> extends DataObject<ID> {

	/**
	 * 获取实体创建时间。
	 *
	 * @return 创建时间。
	 */
	Date getCreateTime();

	/**
	 * 获取实体创建者。
	 *
	 * @return 创建者。
	 */
	<U extends User> U getCreator();

	/**
	 * 获取实体最后一次更新时间。
	 *
	 * @return 最后一次更新时间。
	 */
	Date getUpdateTime();

	/**
	 * 获取实体最后一次更新者。
	 *
	 * @return 最后一次更新者。
	 */
	<U extends User> U getUpdator();

	/**
	 * 获取实体更新的版本，用于实现乐观锁。
	 *
	 * @return 更新的版本。
	 */
	Integer getVersion();

}
