package com.mangooa.platform.manage.profile;

import com.mangooa.common.platform.manage.PlatformProfile;
import com.mangooa.data.jpa.BaseJpaEntityStringId;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 平台配置实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "PlatformProfile")
@Table(
	name = "sys_platform_profile",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = "f_domain")
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class PlatformProfileEntity extends BaseJpaEntityStringId implements PlatformProfile {

	private static final long serialVersionUID = 5427895170597551832L;

	/**
	 * 创建一个平台配置实体对象。
	 *
	 * @param domain 平台域名。
	 * @return 平台配置实体对象。
	 */
	static PlatformProfileEntity of(String domain) {
		PlatformProfileEntity ret = new PlatformProfileEntity();
		ret.setDomain(domain);
		return ret;
	}

	/**
	 * 平台域名。
	 */
	@Column(name = "f_domain", nullable = false, updatable = false, length = 32)
	private String domain;
}
