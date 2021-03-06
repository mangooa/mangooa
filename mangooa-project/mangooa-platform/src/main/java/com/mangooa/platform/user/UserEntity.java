package com.mangooa.platform.user;

import com.mangooa.data.jpa.BaseJpaEntityStringId;

import com.mangooa.tools.core.util.IdUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 平台用户实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "User")
@Table(
	name = "sys_user",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_account"}),
		@UniqueConstraint(columnNames = {"f_username"}),
		@UniqueConstraint(columnNames = {"f_email"}),
		@UniqueConstraint(columnNames = {"f_cellphone"})
	},
	indexes = {
		@Index(columnList = "f_name")
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
@SuppressWarnings("unused")
public class UserEntity extends BaseJpaEntityStringId implements com.mangooa.common.platform.user.User {

	private static final long serialVersionUID = 5489315593638861070L;

	/**
	 * 新建一个用户实体。
	 *
	 * @param email    用户电子邮件。
	 * @param password 用户登录密码。
	 * @return 用户实体对象。
	 */
	static UserEntity of(String email, String password) {
		return of(null, email, password, null, null, null, null, null);
	}

	/**
	 * 新建一个用户实体。
	 *
	 * @param account  用户账号，创建后不可以修改。
	 * @param password 用户登录密码。
	 * @param name     用户姓名。
	 * @param email    用户电子邮件。
	 * @param tenant   用户所属租户。
	 * @return 用户实体对象。
	 */
	static UserEntity of(String account, String password, String name, String email, String tenant) {
		return of(account, null, password, name, null, email, null, tenant);
	}

	/**
	 * 新建一个用户实体。
	 *
	 * @param account   用户账号，创建后不可以修改。
	 * @param username  用户登录账号。
	 * @param password  用户登录密码。
	 * @param name      用户姓名。
	 * @param nickname  用户昵称。
	 * @param email     用户电子邮件。
	 * @param cellphone 用户手机号。
	 * @param tenant    用户所属租户。
	 * @return 用户实体对象。
	 */
	private static UserEntity of(String account, String username, String password, String name, String nickname, String email, String cellphone, String tenant) {
		UserEntity ret = new UserEntity();
		ret.setAccount(account == null ? IdUtils.objectId() : account.trim().toLowerCase());
		ret.setUsername(username == null ? account : username.trim());
		ret.setPassword(password.trim());
		ret.setName(name.trim());
		ret.setNickname(nickname == null ? name : nickname.trim());
		ret.setEmail(email != null ? email.trim().toLowerCase() : null);
		ret.setCellphone(cellphone != null ? cellphone.trim() : null);
		ret.setTenant(tenant != null ? tenant.trim().toLowerCase() : null);
		return ret;
	}

	/**
	 * 用户账号。
	 */
	@Column(name = "f_account", nullable = false, updatable = false, length = 32)
	private String account;

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
	 * 用户姓名。
	 */
	@Column(name = "f_name", nullable = false, length = 32)
	private String name;

	/**
	 * 用户昵称。
	 */
	@Column(name = "f_nickname", length = 32)
	private String nickname;

	/**
	 * 用户电子邮件。
	 */
	@Column(name = "f_email", length = 64)
	private String email;

	/**
	 * 用户手机号。
	 */
	@Column(name = "f_cellphone", length = 16)
	private String cellphone;

	/**
	 * 用户是否启用，默认为false表示未启用。
	 */
	@Column(name = "f_enabled", nullable = false)
	private boolean enabled = false;
}
