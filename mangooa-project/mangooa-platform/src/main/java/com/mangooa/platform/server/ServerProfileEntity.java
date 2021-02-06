package com.mangooa.platform.server;

import com.mangooa.common.platform.server.ServerProfile;
import com.mangooa.common.platform.user.User;
import com.mangooa.data.jpa.BaseJpaEntityStringId;


import com.mangooa.platform.PlatformProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 服务器配置实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "ServerProfile")
@Table(
	name = "sys_server_profile",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_name"})
	}
)
@Getter
@Setter(AccessLevel.PRIVATE)
public class ServerProfileEntity extends BaseJpaEntityStringId implements ServerProfile, User {

	private static final long serialVersionUID = 512888138497333142L;

	/**
	 * 创建一个服务器配置实体对象。
	 *
	 * @param server 服务器配置。
	 * @return 服务器配置实体对象。
	 */
	static ServerProfileEntity of(PlatformProperties.Server server) {
		ServerProfileEntity ret = new ServerProfileEntity();
		ret.setDomain(server.getDomain().trim());
		ret.setAccount(server.getAccount().trim());
		ret.setTenant(server.getTenant());
		return ret;
	}

	/**
	 * 服务器账号。
	 */
	@Column(name = "f_account", nullable = false, updatable = false, length = 32)
	private String account;

	/**
	 * 服务器域名。
	 */
	@Column(name = "f_domain", nullable = false, length = 32)
	private String domain;

	/**
	 * 服务器描述。
	 */
	@Column(name = "f_description", length = 256)
	private String description;
}
