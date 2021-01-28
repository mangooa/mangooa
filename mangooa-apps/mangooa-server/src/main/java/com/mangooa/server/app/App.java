package com.mangooa.server.app;

import com.mangooa.app.AppType;
import com.mangooa.data.jpa.BaseJpaEntityStringId;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 应用实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "App")
@Table(
	name = "t_app",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"b_tenant", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class App extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -6248535765695494180L;

	/**
	 * 新建一个应用实体。
	 *
	 * @param title 应用的标题。
	 * @param name  应用的名称。
	 * @param type  应用的类型。
	 * @return 应用实体对象。
	 */
	public static App of(String title, String name, AppType type) {
		App ret = new App();
		ret.setTitle(title.trim());
		ret.setName(name.trim().toLowerCase());
		ret.setType(type);
		return ret;
	}

	/**
	 * 应用的类型。
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "f_type", nullable = false, length = 32)
	private AppType type;

	/**
	 * 应用标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 应用名称，只可以包含英文字母及下划线。
	 */
	@Setter(AccessLevel.PRIVATE)
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 应用类别。
	 */
	@Column(name = "f_category", length = 32)
	private String category;

}
