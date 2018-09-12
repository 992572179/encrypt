package com.example.encrypt;

/**
 * 
 * @author kawano
 * @date 2018年9月12日
 * @description BinaryUtils
 */
public class BinaryUtils {
	private BinaryUtils() {
		// private constructor.
	}

	public static String dec2binary(Integer i) {
		return Integer.toBinaryString(i);
	}

	public static String dec2Hex(Integer i) {
		return Integer.toHexString(i);
	}

}
