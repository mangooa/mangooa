package com.mangooa.server.app;

import com.mangooa.common.uaa.User;
import com.mangooa.data.jpa.JpaServiceStringId;
import com.mangooa.server.ServerAppProperties;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface AppService extends JpaServiceStringId<AppRepository, App> {

	/**
	 * 初始化当前服务器应用配置。
	 *
	 * @param properties 服务器应用配置。
	 * @param user       初始化当前服务器应用配置创建者。
	 */
	void init(ServerAppProperties properties, User user);

	/**
	 * 根据给定的应用名称查找指定租户下对应的应用实体，如果找不到则返回{@code null}。
	 *
	 * @param name   给定的应用名称。
	 * @param tenant 指定租户的名称。
	 * @return 应用实体对象。
	 */
	App findByName(String name, String tenant);

	/**
	 * 根据给定的应用名称查找指定租户下对应应用实体的数量，如果找不到则返回零。
	 *
	 * @param name   给定的应用名称。
	 * @param tenant 指定租户的名称。
	 * @return 应用实体的数量。
	 */
	long countByName(String name, String tenant);
}
