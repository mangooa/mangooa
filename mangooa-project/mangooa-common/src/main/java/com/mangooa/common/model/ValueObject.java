package com.mangooa.common.model;

import java.io.Serializable;

/**
 * 值对象（POJO）接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface ValueObject extends Serializable {

	/**
	 * 返回值对象唯一标识。
	 *
	 * @return 值对象唯一标识。
	 */
	String getId();
}
