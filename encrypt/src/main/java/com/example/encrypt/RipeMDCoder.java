package com.example.encrypt;

import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

/**
 * 
 * @author kawano
 * @date 2018年9月11日
 * @description
 */
public class RipeMDCoder {
	private RipeMDCoder() {
		// private constructor.
	}

	private static final String RIPE_ALGORITHM = "RipeMD160";
	private static final String HMAC_ALGORITHM = "HmacRipeMD160";

	public static byte[] encodeRipeMD160(byte[] input) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest digest = MessageDigest.getInstance(RIPE_ALGORITHM);
		return digest.digest(input);
	}

	public static String encode2Hex(byte[] input) throws Exception {
		byte[] b = encodeRipeMD160(input);
		return new String(Hex.encode(b));
	}

	public static byte[] initHmacRipeMD160Key() throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		KeyGenerator generator = KeyGenerator.getInstance(HMAC_ALGORITHM);
		SecretKey sk = generator.generateKey();
		return sk.getEncoded();

	}

	public static byte[] encodeHmacRipeMD160(byte[] data, byte[] key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		SecretKey sk = new SecretKeySpec(key, HMAC_ALGORITHM);
		Mac mac = Mac.getInstance(sk.getAlgorithm());
		mac.init(sk);
		return mac.doFinal(data);
	}

	public static String encodeHmac2Hex(byte[] data, byte[] key) throws Exception {
		byte[] b = encodeHmacRipeMD160(data, key);
		return new String(Hex.encode(b));
	}

}
