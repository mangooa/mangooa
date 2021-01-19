package com.mangooa.common.domain;

import com.mangooa.tools.core.lang.Assert;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * 编辑者。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter(AccessLevel.PRIVATE)
@Embeddable
public class Editor implements User {

	/**
	 * 创建一个编辑者对象。
	 *
	 * @param user 用户对象。
	 * @return 编辑者对象。
	 */
	public static Editor of(User user) {
		return of(user.getTenant(), user.getAccount(), user.getName());
	}

	/**
	 * 创建一个编辑者对象。
	 *
	 * @param tenant  编辑者登录的租户。
	 * @param account 编辑者账号。
	 * @param name    编辑者姓名。
	 * @return 编辑者对象。
	 */
	public static Editor of(String tenant, String account, String name) {
		Editor ret = new Editor();
		ret.setTenant(tenant.trim().toLowerCase());
		ret.setAccount(account.trim());
		ret.setName(name.trim());
		return ret;
	}

	/**
	 * 编辑者登录的租户。
	 */
	@Transient
	private String tenant;

	/**
	 * 编辑者账号。
	 */
	private String account;

	/**
	 * 编辑者姓名。
	 */
	private String name;
}
