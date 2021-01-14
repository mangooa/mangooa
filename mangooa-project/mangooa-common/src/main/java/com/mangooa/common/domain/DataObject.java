package com.mangooa.common.domain;

import java.io.Serializable;

/**
 * 数据对象接口。
 *
 * @param <ID> 数据对象唯一标识类型。
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface DataObject<ID extends Serializable> {

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

}
