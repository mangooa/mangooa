package com.mangooa.server.app.ui.form;

import com.mangooa.data.jpa.BaseJpaEntityStringId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 表单实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Form")
@Table(
	name = "t_form",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_app", "f_name"})
	}
)
public class FormEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 1951883641360422801L;

	/**
	 * 表单所属应用。
	 */
	@Column(name = "f_app", nullable = false, updatable = false, length = 32)
	private String app;

	/**
	 * 表单标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 表彰名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

}
