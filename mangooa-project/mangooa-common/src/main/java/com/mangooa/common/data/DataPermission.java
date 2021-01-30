package com.mangooa.common.data;

import java.io.Serializable;

/**
 * 数据权限接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface DataPermission extends Serializable {

	/**
	 * 返回数据权限代码。
	 *
	 * @return 权限代码。
	 */
	String getCode();
}
