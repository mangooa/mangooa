package com.mangooa.server.profile;

import com.mangooa.data.jpa.BaseJpaEntityStringId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 服务器配置实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "ServerProfile")
@Table(
	name = "t_server_profile"
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class ServerProfileEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 4226606781149310199L;

	/**
	 * 构造函数。
	 */
	public ServerProfileEntity() {
		super();
	}

	/**
	 * 构造函数。
	 *
	 * @param tenant 租户名称。
	 */
	ServerProfileEntity(String tenant) {
		setTenant(tenant);
	}

	/**
	 * 服务器域，以英文字线点开头，如“.mangooa.com"。
	 */
	@Column(name = "f_domain", nullable = false, updatable = false, length = 32)
	private String domain;


}
