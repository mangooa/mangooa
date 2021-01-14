package com.mangooa.server.uaaa.user;

import com.mangooa.common.domain.BaseJpaEntityStringId;
import com.mangooa.uaaa.domain.User;
import lombok.Getter;

import javax.persistence.*;

/**
 * 用户实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "User")
@Table(
	name = "t_user",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "f_account", name = "uk_user_account"),
		@UniqueConstraint(columnNames = "f_cellphone", name = "uk_user_cellphone")
	},
	indexes = {
		@Index(columnList = "f_name", name = "ix_user_name")
	}
)
@Getter
@SuppressWarnings("unused")
public class UserEntity extends BaseJpaEntityStringId implements User {

	private static final long serialVersionUID = 5489315593638861070L;

	/**
	 * 用户账号。
	 */
	@Column(name = "f_account", nullable = false, updatable = false, length = 32)
	private String account;

	/**
	 * 用户姓名。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 用户手机号。
	 */
	@Column(name = "f_cellphone", length = 16)
	private String cellphone;
}
