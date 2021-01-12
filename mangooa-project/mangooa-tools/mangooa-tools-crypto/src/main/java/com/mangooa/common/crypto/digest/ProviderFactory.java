package com.mangooa.common.crypto.digest;

import com.mangooa.common.crypto.CryptoException;

import java.security.Provider;

/**
 * 信息摘要提供者工厂类。
 *
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class ProviderFactory {

	public static String BOUNCY_CASTLE_PROVIDER_CLASS = "org.bouncycastle.jce.provider.BouncyCastleProvider";

	/**
	 * 创建BouncyCastleProvider。
	 *
	 * @return {@link Provider}
	 * @throws CryptoException 如果未引入BouncyCastle库。
	 */
	public static Provider createBouncyCastleProvider() throws CryptoException {
		try {
			Class<?> clazz = Class.forName(BOUNCY_CASTLE_PROVIDER_CLASS);
			return (Provider) clazz.newInstance();
		} catch (Exception e) {
			throw new CryptoException(e);
		}
	}
}
