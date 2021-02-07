package com.mangooa.platform.setting;

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
public class PlatformProfileEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = 5427895170597551832L;

	/**
	 * 平台域名。
	 */
	@Column(name = "f_domain", nullable = false, updatable = false, length = 32)
	private String domain;
}
