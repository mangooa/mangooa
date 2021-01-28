package com.mangooa.server.app.acl;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 应用角色实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Role")
@Table(
	name = "t_role",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"b_tenant", "f_app", "f_name"})
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class RoleEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -3552029919228343977L;

	/**
	 * 角色所属应用。
	 */
	@Column(name = "f_app", nullable = false, updatable = false, length = 32)
	private String app;

	/**
	 * 角色的名称。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 角色的备注。
	 */
	@Column(name = "f_remark", length = 256)
	private String remark;
}
