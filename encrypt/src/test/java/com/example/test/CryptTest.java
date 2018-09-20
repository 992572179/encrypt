package com.example.test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;

import org.junit.Test;

import com.example.encrypt.RSAEncrypt;
import com.example.encrypt.hash.EncryptCodec;
import com.example.encrypt.hash.HashEncryptJdk;
import lombok.extern.log4j.Log4j;

import com.example.encrypt.hash.HashEncryptBC;

@Log4j
public class CryptTest {

	@Test
	public void testApplyHash() {
		String source = "blockchain";
		String res = null;
		try {
			res = HashEncryptJdk.applySHA256(source);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			log.error(e.getMessage());
		}

		System.out.println(res);
		boolean flag;
		String hexStr = "ef7797e13d3a75526946a3bcf00daec9fc9c9c4d51ddc7cc5df888f74dd434d1";
		flag = hexStr.equals(res);
		log.info(flag);
		log.info(res.length());
	}

	@Test
	public void testCodecEncypt() {
		String str = "sha-1";
		String sha1 = EncryptCodec.applySHA256(str);
		log.info(sha1);
	}

	@Test
	public void testBCEncrypt() {
		String str = "sha-1";
		String res = HashEncryptBC.applySHA256(str);
		log.info(res);
	}

	@Test
	public void testRSA() throws BadPaddingException, Exception {
		String src = "rsa";
		RSAEncrypt.applyRSA(src);
	}

}
