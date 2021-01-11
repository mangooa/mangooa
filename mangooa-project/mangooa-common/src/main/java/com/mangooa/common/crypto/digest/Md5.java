package com.mangooa.common.crypto.digest;

/**
 * 信息摘要算法5。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class Md5 extends DigestWrapper {

	/**
	 * 构造函数。
	 */
	public Md5() {
		super(DigestAlgorithm.MD5);
	}

	/**
	 * 创建一个MD5实例。
	 *
	 * @return MD5实例。
	 */
	public static Md5 create() {
		return new Md5();
	}


}
