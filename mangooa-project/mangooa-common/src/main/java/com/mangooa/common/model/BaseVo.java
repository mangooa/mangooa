package com.mangooa.common.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 值对象基类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
public abstract class BaseVo implements ValueObject {

	private static final long serialVersionUID = -6301270448077482349L;

	/**
	 * 值对象唯一标识。
	 */
	private String uid;

}
