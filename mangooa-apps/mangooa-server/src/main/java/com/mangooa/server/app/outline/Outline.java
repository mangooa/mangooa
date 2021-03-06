package com.mangooa.server.app.outline;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 应用大纲实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Outline")
@Table(
	name = "t_outline",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_app","f_name"})
	}
)
@Getter
@Setter(AccessLevel.PRIVATE)
public class Outline extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -7786603862499930077L;

	/**
	 * 大纲所属应用。
	 */
	@Column(name = "f_app", nullable = false, updatable = false, length = 32)
	private String app;

	/**
	 * 大纲标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 大纲名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

}
