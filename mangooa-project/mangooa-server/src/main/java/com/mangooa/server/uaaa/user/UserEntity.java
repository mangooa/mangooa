package com.mangooa.server.uaaa.user;

import com.mangooa.common.domain.Editor;
import com.mangooa.data.jpa.BaseJpaEntityStringId;
import com.mangooa.uaaa.domain.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

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
		@UniqueConstraint(columnNames = "f_username", name = "uk_user_username"),
		@UniqueConstraint(columnNames = "f_email", name = "uk_user_email"),
		@UniqueConstraint(columnNames = "f_cellphone", name = "uk_user_cellphone")
	},
	indexes = {
		@Index(columnList = "f_name", name = "ix_user_name")
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
@SuppressWarnings("unused")
public class UserEntity extends BaseJpaEntityStringId implements User {

	private static final long serialVersionUID = 5489315593638861070L;

	/**
	 * 新建一个用户实体。
	 *
	 * @param email    用户电子邮件。
	 * @param password 用户登录密码。
	 * @param name     用户姓名。
	 * @return 用户实体对象。
	 */
	public static UserEntity of(String email, String password, String name) {
		UserEntity ret = new UserEntity();
		ret.setEmail(email.trim().toLowerCase());
		ret.setPassword(password);
		ret.setName(name);
		return ret;
	}

	/**
	 * 新建一个用户实体。
	 *
	 * @param email    用户电子邮件。
	 * @param password 用户登录密码。
	 * @return 用户实体对象。
	 */
	public static UserEntity of(String email, String password) {
		return of(email, password);
	}

	/**
	 * 用户账号。
	 */
	@Setter(AccessLevel.PRIVATE)
	@Column(name = "f_account", nullable = false, updatable = false, length = 32)
	private String account;

	/**
	 * 用户姓名。
	 */
	@Column(name = "f_name", nullable = false, length = 32)
	private String name;

	/**
	 * 用户电子邮件。
	 */
	@Column(name = "f_email", length = 64)
	private String email;

	/**
	 * 用户登录名。
	 */
	@Column(name = "f_username", nullable = false, length = 32)
	private String username;

	/**
	 * 用户登录密码。
	 */
	@Column(name = "f_password", nullable = false, length = 64)
	private String password;

	/**
	 * 用户手机号。
	 */
	@Column(name = "f_cellphone", length = 16)
	private String cellphone;

	/**
	 * 用户启用还是禁用，禁用的用户无法通过身份验证，默认为true表示已启用。
	 */
	@Column(name = "f_enabled", nullable = false)
	private boolean enabled = true;
}
