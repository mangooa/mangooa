package com.mangooa.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象接口。
 *
 * @param <ID> 对象唯一标识类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public interface DataObject<ID extends Serializable> extends Serializable {

	/**
	 * 获取对象唯一标识。
	 *
	 * @return 对象唯一标识。
	 */
	ID getId();

	/**
	 * 设置对象唯一标识。
	 *
	 * @param id 对象唯一标识。
	 */
	void setId(ID id);

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
	 * 获取对象更新的版本，用于实现乐观锁。
	 *
	 * @return 更新的版本。
	 */
	Integer getVersion();
}
