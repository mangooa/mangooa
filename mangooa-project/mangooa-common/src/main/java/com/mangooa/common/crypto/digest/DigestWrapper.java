package com.mangooa.common.crypto.digest;

import com.mangooa.common.core.lang.ArrayUtil;
import com.mangooa.common.core.lang.CharsetUtil;
import com.mangooa.common.core.lang.StringUtils;
import com.mangooa.common.crypto.CryptoException;
import com.mangooa.common.crypto.SecurityUtil;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Objects;

/**
 * 摘要算法包装类。
 *
 * @author Weimin Gao
 * @see java.security.MessageDigest
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
class DigestWrapper {

	private MessageDigest digest;

	/**
	 * 盐值。
	 */
	protected byte[] salt;

	/**
	 * 加盐位置，默认0。
	 */
	protected int saltPosition = 0;

	/**
	 * 散列次数，默认1。
	 */
	protected int digestCount = 1;

	/**
	 * 构造函数，使用JDK实现。
	 *
	 * @param algorithm 算法。
	 */
	protected DigestWrapper(DigestAlgorithm algorithm) {
		this(algorithm.value(), null);
	}

	/**
	 * 构造函数，使用JDK实现。
	 *
	 * @param algorithm 算法。
	 */
	protected DigestWrapper(String algorithm) {
		this(algorithm, null);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 算法。
	 * @param provider  算法提供者，传null时表示JDK默认。
	 */
	protected DigestWrapper(DigestAlgorithm algorithm, Provider provider) {
		init(algorithm.value(), provider);
	}

	/**
	 * 构造函数。
	 *
	 * @param algorithm 算法。
	 * @param provider  算法提供者，传null时表示JDK默认。
	 */
	protected DigestWrapper(String algorithm, Provider provider) {
		init(algorithm, provider);
	}

	/**
	 * 初始化消息。
	 *
	 * @param algorithm 算法。
	 * @param provider  算法提供者，传null时表示JDK默认。
	 */
	protected void init(String algorithm, Provider provider) {
		if (Objects.isNull(provider)) {
			this.digest = SecurityUtil.createMessageDigest(algorithm);
		} else {
			try {
				this.digest = MessageDigest.getInstance(algorithm, provider);
			} catch (NoSuchAlgorithmException e) {
				throw new CryptoException(e);
			}
		}
	}

	/**
	 * 设置加盐混淆内容。
	 *
	 * @param salt 盐值。
	 * @return this。
	 */
	public DigestWrapper setSalt(byte[] salt) {
		this.salt = salt;
		return this;
	}

	/**
	 * 设置加盐的位置，盐值存在时（即不为null或空数组时）有效。<br/>
	 *
	 * @param saltPosition 盐值插入的位置。
	 * @return this。
	 */
	public DigestWrapper setSaltPosition(int saltPosition) {
		this.saltPosition = saltPosition;
		return this;
	}

	/**
	 * 设置重复计算摘要值次数。
	 *
	 * @param digestCount 摘要值次数。
	 * @return this。
	 */
	public DigestWrapper setDigestCount(int digestCount) {
		this.digestCount = digestCount;
		return this;
	}

	/**
	 * 重置{@link MessageDigest}。
	 *
	 */
	public void reset() {
		this.digest.reset();
	}

	/**
	 * 生成摘要，使用了加盐和重复摘要次数。
	 *
	 * @param data 待摘要的数据。
	 * @return 摘要。
	 */
	public byte[] digest(byte[] data) {
		byte[] ret;
		if (ArrayUtil.isEmpty(this.salt)) {
			// 无加盐
			ret = digest0(data);
		} else if (this.saltPosition <= 0) {
			// 加盐在开头
			ret = digest0(this.salt, data);
		} else if (this.saltPosition >= data.length) {
			// 加盐在末尾
			ret = digest0(data, this.salt);
		} else {
			// 加盐在中间
			this.digest.update(data, 0, this.saltPosition);
			this.digest.update(this.salt);
			this.digest.update(data, this.saltPosition, data.length - this.saltPosition);
			ret = this.digest.digest();
		}
		return digest1(ret);
	}


	/**
	 * 生成摘要。
	 *
	 * @param data 被摘要数据。
	 * @return 摘要。
	 */
	private byte[] digest0(byte[]... data) {
		for (byte[] element : data) {
			if (null != element) {
				this.digest.update(element);
			}
		}
		return this.digest.digest();
	}

	/**
	 * 重复计算摘要，取决于{@link #digestCount}值。<br/>
	 * 每次计算摘要前都会重置{@link #digest}。
	 *
	 * @param data 第一次摘要过的数据。
	 * @return 摘要。
	 */
	private byte[] digest1(byte[] data) {
		final int digestCount = Math.max(1, this.digestCount);
		reset();
		for (int i = 0; i < digestCount - 1; i++) {
			data = digest0(data);
			reset();
		}
		return data;
	}

	/**
	 * 生成文件摘要。
	 *
	 * @param data 被摘要数据。
	 * @param charset 编码。
	 * @return 摘要。
	 */
	public byte[] digest(String data, String charset) {
		return digest(data, CharsetUtil.charset(charset));
	}

	/**
	 * 生成文件摘要。
	 *
	 * @param data 被摘要数据。
	 * @param charset 编码。
	 * @return 摘要。
	 */
	public byte[] digest(String data, Charset charset) {
		return digest(StringUtils.bytes(data, charset));
	}

}
