package com.mangooa.server.app.view;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "View")
@Table(
	name = "t_view",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_app", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PRIVATE)
public class ViewEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 4354174405594690417L;

	/**
	 * 视图所属应用。
	 */
	@Column(name = "f_app", nullable = false, updatable = false, length = 32)
	private String app;

	/**
	 * 视图标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 视图名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;
}
