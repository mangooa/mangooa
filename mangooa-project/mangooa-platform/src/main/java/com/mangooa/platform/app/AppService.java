package com.mangooa.platform.app;

import com.mangooa.common.platform.app.AppType;
import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.JpaServiceStringId;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public interface AppService extends JpaServiceStringId<AppRepository, AppEntity> {

	/**
	 * 新建应用。
	 *
	 * @param creator 创建者。
	 * @param type    应用类型。
	 * @param name    应用名称。
	 * @param title   应用标题。
	 * @return 应用实体对象。
	 * @throws AppNameExistsException 如果应用名称已存在时。
	 */
	AppEntity create(User creator, AppType type, String name, String title) throws AppNameExistsException;

	/**
	 * 查找给定用户登录租户下指定应用名称对应的应用实体，如果找不到返回{@code null}。
	 *
	 * @param user 用户。
	 * @param name 应用名称。
	 * @return 应用实体对象。
	 */
	AppEntity find(User user, String name);
}
