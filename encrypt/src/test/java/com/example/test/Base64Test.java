package com.example.test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.example.encrypt.BinaryUtils;

import lombok.extern.log4j.Log4j;

@Log4j
public class Base64Test {

	@Test
	public void testBase64Encode() {
		String str = "a";
		byte[] base64 = Base64.encodeBase64(str.getBytes());
		String res = new String(base64);
		log.info(res);
	}
	
	@Test
	public void testBase64Decode() {
		String source = "aGVsbG8=";
		byte[] decode = Base64.decodeBase64(source.getBytes());
		String res = new String(decode);
		log.info(res);
	}
	
	@Test
	public void testAscii() {
		Integer value = Integer.valueOf('a');
		System.out.println(value);
	}

	@Test
	public void testGetBinary() {
		String res = BinaryUtils.dec2binary(97);
		System.out.println(res);
	}
}
