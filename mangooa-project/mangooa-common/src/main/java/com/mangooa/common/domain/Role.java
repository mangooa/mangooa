package com.mangooa.common.domain;

import java.io.Serializable;

/**
 * 角色接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface Role extends Serializable {

	/**
	 * 获取角色的名称。
	 *
	 * @return 角色的名称。
	 */
	String getName();

}
