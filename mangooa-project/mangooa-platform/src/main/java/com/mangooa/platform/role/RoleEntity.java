package com.mangooa.platform.role;

import com.mangooa.common.platform.role.Role;
import com.mangooa.common.platform.role.RoleType;
import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 角色实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Role")
@Table(
	name = "sys_role"
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class RoleEntity extends BaseJpaEntityStringId implements Role {

	private static final long serialVersionUID = 2248515729125400881L;

	/**
	 * 角色代码。
	 */
	@Column(name = "f_code", nullable = false, updatable = false, length = 32)
	private String code;

	/**
	 * 角色名称。
	 */
	@Column(name = "f_name", nullable = false, length = 32)
	private String name;

	/**
	 * 角色类型。
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "f_type", nullable = false, updatable = false, length = 32)
	private RoleType type;

}
