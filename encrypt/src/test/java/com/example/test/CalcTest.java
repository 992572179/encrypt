package com.example.test;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class CalcTest {

	@Test
	public void testHex() {
		String hexStr = "3fffe000";
		int parseInt = Integer.parseInt(hexStr, 16);
		log.info(parseInt);
		
		Integer i = 0x3fffe000;
		log.info(Integer.toHexString(i));
		
		Integer binary = 0b01011100;
		String binaryString = Integer.toBinaryString(binary);
		System.out.println(binaryString);
		int parseInt2 = Integer.parseInt(binaryString.toString(),2);
		System.out.println(parseInt2);

	}

}
