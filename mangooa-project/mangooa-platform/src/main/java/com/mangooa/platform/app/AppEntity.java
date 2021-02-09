package com.mangooa.platform.app;

import com.mangooa.common.platform.app.App;
import com.mangooa.common.platform.app.AppType;
import com.mangooa.data.jpa.BaseJpaEntityStringId;

import com.mangooa.tools.core.util.IdUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter(AccessLevel.PACKAGE)
public class AppEntity extends BaseJpaEntityStringId implements App {

	private static final long serialVersionUID = 1135079420105159410L;

	/**
	 * 创建一个应用实体。
	 *
	 * @param type  应用类型。
	 * @param name  应用名称。
	 * @param title 应用标题。
	 * @return 应用实体对象。
	 */
	static AppEntity of(AppType type, String name, String title) {
		AppEntity ret = new AppEntity();
		ret.setType(type);
		ret.setName(name);
		ret.setTitle(title);
		ret.setClientId(IdUtils.simpleUuid());
		ret.setClientSecret(IdUtils.simpleUuid());
		return ret;
	}

	/**
	 * 应用名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 应用标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 应用类型。
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "f_type", nullable = false, length = 32)
	private AppType type;

	/**
	 * 应用认证客户端ID。
	 */
	@Column(name = "f_client_id", nullable = false, updatable = false, length = 32)
	private String clientId;

	/**
	 * 应用认证证客户端密码。
	 */
	@Column(name = "f_client_secret", nullable = false, length = 32)
	private String clientSecret;

}
