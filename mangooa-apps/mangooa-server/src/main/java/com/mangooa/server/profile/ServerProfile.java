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
public class ServerProfile extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 4226606781149310199L;

	/**
	 * 新建一个服务器配置实体对象。
	 *
	 * @param domain 服务器的域。
	 * @return 服务器配置实体对象。
	 */
	public static ServerProfile of(String domain) {
		ServerProfile ret = new ServerProfile();
		ret.setDomain(domain.trim().toLowerCase());
		return ret;
	}

	/**
	 * 服务器域，以英文字线点开头，如“.mangooa.com"。
	 */
	@Column(name = "f_domain", nullable = false, updatable = false, length = 32)
	private String domain;


}
