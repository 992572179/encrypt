package com.example.encrypt.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author kawano
 * @date 2018年9月10日
 * @description 哈希工具类，根据文本生成哈希摘要
 * 
 */
public class HashEncryptJdk {
	
	private HashEncryptJdk() {
		//private constructor.
	}

	public static String applySHA256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(input.getBytes("UTF-8"));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; i++) {
			String hexStr = Integer.toHexString(0xff & hash[i]);
			if (hexStr.length() == 1) {
				sb.append('0');
			}
			sb.append(hexStr);
		}
		return sb.toString();
	}
	
	

}
