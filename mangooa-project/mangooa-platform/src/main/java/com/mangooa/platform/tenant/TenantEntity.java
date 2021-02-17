package com.mangooa.platform.tenant;

import com.mangooa.data.jpa.BaseJpaEntityStringId;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 租户实体。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Entity(name = "Tenant")
@Table(
	name = "sys_tenant",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"f_name"})
	}
)
@Getter
@Setter(AccessLevel.PACKAGE)
public class TenantEntity extends BaseJpaEntityStringId {

	private static final long serialVersionUID = -2725123851168927991L;

	/**
	 * 新建一个租户实体对象。
	 *
	 * @param name   租户名称。
	 * @param domain 租户访问域名。
	 * @return 租户实体对象。
	 */
	static TenantEntity of(String name, String domain) {
		TenantEntity ret = new TenantEntity();
		ret.setName(name);
		ret.setDomain(domain);
		return ret;
	}

	/**
	 * 租户名称，只可以包含英文字母和中划线。
	 */
	@Column(name = "f_name", nullable = false, updatable = false, length = 32)
	private String name;

	/**
	 * 租户访问域名。
	 */
	@Column(name = "f_domain", nullable = false, length = 32)
	private String domain;


}
