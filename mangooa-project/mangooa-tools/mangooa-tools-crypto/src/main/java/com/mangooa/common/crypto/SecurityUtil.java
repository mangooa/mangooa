package com.mangooa.common.crypto;

import com.mangooa.common.crypto.digest.GlobalBouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * 安全相关工具类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
@SuppressWarnings("unused")
public final class SecurityUtil {

	private static final Provider PROVIDER = GlobalBouncyCastleProvider.INSTANCE.getProvider();

	/**
	 * 创建一个信息摘要实例。<br/>
	 * 如果类路径中包含BouncyCastle库则使用BouncyCastleProvider算法提供者，否则使用JDK算法提供者。
	 *
	 * @param algorithm 信息摘要算法。
	 * @return 信息摘要实例。
	 */
	public static MessageDigest createMessageDigest(String algorithm) {
		try {
			return (null == PROVIDER) ? MessageDigest.getInstance(algorithm) : MessageDigest.getInstance(algorithm, PROVIDER);
		} catch (NoSuchAlgorithmException e) {
			throw new CryptoException(e);
		}
	}

}
