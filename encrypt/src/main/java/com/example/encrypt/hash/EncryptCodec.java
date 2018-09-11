package com.example.encrypt.hash;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author kawano
 * @date 2018年9月10日
 * @description Apache commons-codec encrypt
 */
public class EncryptCodec {

	private EncryptCodec() {
		// private constructor.
	}

	public static String applySHA1(String input) {
		return DigestUtils.sha1Hex(input);
	}

	public static String applySHA256(String input) {
		return DigestUtils.sha256Hex(input);
	}

	public static String applySHA512(String input) {
		return DigestUtils.sha512Hex(input);
	}

}
