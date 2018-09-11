package com.example.encrypt.hash;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * 
 * @author kawano
 * @date 2018年9月10日
 * @description Bouncy Castle加密工具包
 */
public class HashEncryptBC {
	private HashEncryptBC() {
		//private constructor.
	}
	
	public static String applySHA1(String input) {
		Digest digest = new SHA1Digest();
		digest.update(input.getBytes(), 0, input.getBytes().length);
		byte[] sha1Byte = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Byte, 0);
		return new String(Hex.encode(sha1Byte));
	}
	
	public static String applySHA256(String input) {
		Digest digest = new SHA256Digest();
		digest.update(input.getBytes(), 0, input.getBytes().length);
		byte[] sha256Byte = new byte[digest.getDigestSize()];
		digest.doFinal(sha256Byte, 0);
		return new String(Hex.encode(sha256Byte));
		
	}
	
	public static String applySHA512(String input) {
		Digest digest = new SHA512Digest();
		digest.update(input.getBytes(), 0, input.getBytes().length);
		byte[] sha512Byte = new byte[digest.getDigestSize()];
		digest.doFinal(sha512Byte, 0);
		return new String(Hex.encode(sha512Byte));
		
	}
	


}
