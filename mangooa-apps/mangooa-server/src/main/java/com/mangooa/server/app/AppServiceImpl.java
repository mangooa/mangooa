package com.mangooa.server.app;

import com.mangooa.common.platform.app.AppType;
import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaServiceStringId;

import com.mangooa.server.ServerAppProperties;
import org.springframework.stereotype.Service;

import static com.mangooa.server.ServerAppConstant.INIT_TENANT_NAME;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Service
public class AppServiceImpl extends BaseJpaServiceStringId<AppRepository, App> implements AppService {

	/**
	 * 根据给定的应用名称查找指定租户下对应的应用实体，如果找不到则返回{@code null}。
	 *
	 * @param name   给定的应用名称。
	 * @param tenant 指定租户的名称。
	 * @return 应用实体对象。
	 */
	@Override
	public App findByName(String name, String tenant) {
		return getDao().findByNameIgnoreCaseAndTenantIgnoreCase(name.trim(), tenant.trim());
	}

	/**
	 * 根据给定的应用名称查找指定租户下对应应用实体的数量，如果找不到则返回零。
	 *
	 * @param name   给定的应用名称。
	 * @param tenant 指定租户的名称。
	 * @return 应用实体的数量。
	 */
	@Override
	public long countByName(String name, String tenant) {
		return getDao().countByNameIgnoreCaseAndTenantIgnoreCase(name.trim(), tenant.trim());
	}

	/**
	 * 初始化当前服务器应用配置。
	 *
	 * @param properties 服务器应用配置。
	 * @param user       初始化当前服务器应用配置创建者。
	 */
	@Override
	public void init(ServerAppProperties properties, User user) {
		ServerAppProperties.Init init = properties.getInit();
		if (init.isEnable()) {
			String name = properties.getName();
			if (countByName(name, INIT_TENANT_NAME) == 0) {
				App entity = App.of("应用服务器", name, AppType.WEB);
				save(user,entity);
			}
		}
	}
}
