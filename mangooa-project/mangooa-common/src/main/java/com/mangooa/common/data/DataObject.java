package com.mangooa.common.data;

import java.io.Serializable;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface DataObject<ID extends Serializable> {

	/**
	 * 返回对象唯一标识。
	 *
	 * @return 对象唯一标识。
	 */
	ID getId();
}
