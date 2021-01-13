package com.mangooa.common.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 创建者。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
@Embeddable
public class Creator implements User {

	private static final long serialVersionUID = 7287889654718274191L;

	/**
	 * 创建者账号。
	 */
	private String account;

	/**
	 * 创建者姓名。
	 */
	private String name;

}
