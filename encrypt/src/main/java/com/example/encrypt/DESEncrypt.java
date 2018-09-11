package com.example.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * 
 * @author kawano
 * @date 2018年9月10日
 * @description DES
 */
public class DESEncrypt {

	private DESEncrypt() {
		// private constructor.
	}

	private static final String ALGORITHM = "DES/ECB/PKCS5Padding";

	public static String applyDES(String input) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		keyGenerator.init(56);
		SecretKey secretKey = keyGenerator.generateKey();
		byte[] key = secretKey.getEncoded();

		DESKeySpec desKeySpec = new DESKeySpec(key);
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		SecretKey key2 = factory.generateSecret(desKeySpec);

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key2);
		byte[] result = cipher.doFinal(input.getBytes());
		Hex.encodeHexString(result);

		cipher.init(Cipher.DECRYPT_MODE, key2);
		result = cipher.doFinal(result);
		return new String(result);

	}

}
