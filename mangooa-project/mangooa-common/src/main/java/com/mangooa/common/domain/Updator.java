package com.mangooa.common.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 更新者。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
@Embeddable
public class Updator implements User {

	private static final long serialVersionUID = 4080894331626456936L;

	/**
	 * 创建者账号。
	 */
	private String account;

	/**
	 * 创建者姓名。
	 */
	private String name;
}
