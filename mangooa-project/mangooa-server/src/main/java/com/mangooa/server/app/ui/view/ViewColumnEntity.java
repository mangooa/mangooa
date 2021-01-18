package com.mangooa.server.app.ui.view;

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
@Entity(name = "ViewColumn")
@Table(
	name = "t_view_column",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_app", "f_view", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PRIVATE)
public class ViewColumnEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -8656481684770021149L;

	/**
	 * 视图列所属应用。
	 */
	@Column(name = "f_app", nullable = false, updatable = false, length = 32)
	private String app;

	/**
	 * 视图列所属视图。
	 */
	@Column(name = "f_view", nullable = false, updatable = false, length = 32)
	private String view;

	/**
	 * 视图列标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 视图列名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;
}
