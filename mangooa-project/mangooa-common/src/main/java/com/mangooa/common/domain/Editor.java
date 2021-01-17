package com.mangooa.common.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 编辑者。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@Getter
@Setter
@Embeddable
public class Editor implements User {

	/**
	 * 创建一个编辑者对象。
	 *
	 * @param user 用户对象。
	 * @return 编辑者对象。
	 */
	public static Editor of(User user) {
		Editor editor = new Editor();
		editor.setAccount(user.getAccount());
		editor.setName(user.getName());
		return editor;
	}

	/**
	 * 编辑者账号。
	 */
	private String account;

	/**
	 * 编辑者姓名。
	 */
	private String name;
}
