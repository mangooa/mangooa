package com.mangooa.tools.crypto.digest;

/**
 * MD5信息摘要算法。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
class Md5 extends MessageDigest {

	/**
	 * 构造函数。
	 */
	public Md5() {
		super(DigestAlgorithm.MD5);
	}

	/**
	 * 构造函数。
	 *
	 * @param salt         盐值。
	 * @param saltPosition 加盐位置，即将盐值字符串放置在数据的索引数，默认0。
	 * @param digestCount  摘要次数，当此值小于等于1，默认为1。
	 */
	public Md5(byte[] salt, int saltPosition, int digestCount) {
		this();
		this.salt = salt;
		this.saltPosition = saltPosition;
		this.digestCount = digestCount;
	}

	/**
	 * 构造函数。
	 *
	 * @param salt 盐值。
	 */
	public Md5(byte[] salt) {
		this(salt, 0, 1);
	}

	/**
	 * 构造函数。
	 *
	 * @param salt        盐值。
	 * @param digestCount 摘要次数。
	 */
	public Md5(byte[] salt, int digestCount) {
		this(salt, 0, digestCount);
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
