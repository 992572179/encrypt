package com.example.encrypt.rsa;
/**
 * 
 * @author kawano
 * @date 2018年9月10日
 * @description
 */

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

import lombok.extern.log4j.Log4j;

@Log4j
public class RSAEncrypt {

	private RSAEncrypt() {

	}

	private static final String ALGORITHM = "RSA";

	public static void applyRSA(String src) throws BadPaddingException, Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.genKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

		Base64.encodeBase64(rsaPublicKey.getEncoded());
		Base64.encodeBase64(rsaPrivateKey.getEncoded());
		
		// 私钥加密，公钥解密-->加密
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey privateKey = factory.generatePrivate(spec);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] result = cipher.doFinal(src.getBytes());
		if (log.isDebugEnabled()) {
			log.info("-->rsa加密:" + Base64.encodeBase64String(result));
		}
		
		
		X509EncodedKeySpec spec2 = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		factory = KeyFactory.getInstance(ALGORITHM);
		PublicKey pk = factory.generatePublic(spec2);
		cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, pk);
		result = cipher.doFinal(result);
		if (log.isDebugEnabled()) {
			log.info("-->rsa解密" + Base64.encodeBase64String(result));
		}
	}
}
