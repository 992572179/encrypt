package com.example.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;

import org.junit.Test;

import com.example.encrypt.RSAEncrypt;
import com.example.encrypt.hash.EncryptCodec;
import com.example.encrypt.hash.HashEncryptJdk;
import com.example.encrypt.hash.HashEncryptBC;

public class CryptTest {

	@Test
	public void testApplyHash() {
		String source = "blockchain";
		String res = null;
		try {
			res = HashEncryptJdk.applySHA256(source);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println(res);
		boolean flag;
		String hexStr = "ef7797e13d3a75526946a3bcf00daec9fc9c9c4d51ddc7cc5df888f74dd434d1";
		flag = hexStr.equals(res);
		System.out.println(flag);
		System.out.println(res.length());
	}

	@Test
	public void testCodecEncypt() {
		String str = "sha-1";
		String sha1 = EncryptCodec.applySHA256(str);
		System.out.println(sha1);
	}

	@Test
	public void testBCEncrypt() {
		String str = "sha-1";
		String res = HashEncryptBC.applySHA256(str);
		System.out.println(res);
	}
	
	@Test
	public void testRSA() throws BadPaddingException, Exception {
		String src = "rsa";
		RSAEncrypt.applyRSA(src);
	}

}
