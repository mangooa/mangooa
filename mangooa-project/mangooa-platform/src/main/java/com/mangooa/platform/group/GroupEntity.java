package com.mangooa.platform.group;

import com.mangooa.common.platform.group.Group;
import com.mangooa.data.jpa.BaseJpaEntityStringId;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 群组实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Group")
@Table(
	name = "sys_group",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"b_tenant", "f_code"})
	}
)
@Getter
@Setter(AccessLevel.PRIVATE)
public class GroupEntity extends BaseJpaEntityStringId implements Group {

	private static final long serialVersionUID = -4795536595416851001L;

	/**
	 * 群组代码（同一租户下唯一），创建后不可以修改。
	 */
	@Column(name = "f_code", nullable = false, updatable = false, length = 32)
	private String code;

	/**
	 * 群组名称。
	 */
	@Column(name = "f_name", nullable = false, length = 64)
	private String name;

}
