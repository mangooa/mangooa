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
		@UniqueConstraint(columnNames = {"b_tenant", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class AppEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -6248535765695494180L;

	/**
	 * 应用路径，默认为正斜杠"/"。
	 */
	@Column(name = "f_path", nullable = false, length = 32)
	private String path = "/";

	/**
	 * 应用名称，只可以包含英文字母及下划线。
	 */
	@Column(name = "f_name", nullable = false, length = 32)
	private String name;

}
