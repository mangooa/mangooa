package com.mangooa.common.domain;

import java.io.Serializable;

/**
 * 权限接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Permission extends Serializable {

	/**
	 * 获取权限的名称。
	 *
	 * @return 权限的名称。
	 */
	String getName();

}
