package com.mangooa.server.app.ui.outline;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 大纲项实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "OutlineItem")
@Table(
	name = "t_outline_item",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_app", "f_outline", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PRIVATE)
public class OutlineItemEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 3468803501673585434L;

	/**
	 * 大纲项所属应用。
	 */
	@Column(name = "f_app", nullable = false, updatable = false, length = 32)
	private String app;

	/**
	 * 大纲项所属大纲。
	 */
	@Column(name = "f_outline", nullable = false, updatable = false, length = 32)
	private String outline;

	/**
	 * 大纲项标题。
	 */
	@Column(name = "f_title", nullable = false, length = 32)
	private String title;

	/**
	 * 大纲项名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 大纲项层级，格式如：1、1/1、2、3、3/1、3/1/1。
	 */
	@Column(name = "f_level", nullable = false, length = 32)
	private String level;

}
