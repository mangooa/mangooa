package com.mangooa.server.app;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
		@UniqueConstraint(columnNames = {"b_tenant", "f_name"}),
		@UniqueConstraint(columnNames = {"f_url"})
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class AppEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -6248535765695494180L;

	/**
	 * 应用名称，只可以包含英文字母及下划线。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 应用访问地址。<br/>
	 * 格式：scheme://hostname[:port]/name.app[?query][#hash]。<br/>
	 * 例子：http://mangooa.cn/wlan.app
	 */
	@Column(name = "f_url", nullable = false, length = 32)
	private String url;

	/**
	 * 应用类别，格式：名称|代码，如：协同效率|10000001。
	 */
	@Column(name = "f_category", length = 32)
	private String category;

	/**
	 * 应用标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

}
