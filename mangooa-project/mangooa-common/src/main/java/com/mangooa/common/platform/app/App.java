package com.mangooa.common.platform.app;

import java.io.Serializable;

/**
 * 应用接口。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface App extends Serializable {

	/**
	 * 返回应用名称。
	 *
	 * @return 应用名称。
	 */
	String getName();

	/**
	 * 返回应用标题。
	 *
	 * @return 应用标题。
	 */
	String getTitle();

	/**
	 * 返回应用类型。
	 *
	 * @return 应用类型。
	 */
	AppType getType();

	/**
	 * 返回应用认证客户端ID。
	 *
	 * @return 客户端ID。
	 */
	String getClientId();

	/**
	 * 返回应用认证客户端密码。
	 *
	 * @return 客户端密码。
	 */
	String getClientSecret();


}
