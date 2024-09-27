package com.vegetable.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PracticeApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void concatTest(){

		String stringOne = "Hello ";
		String stringTwo = "World";

		assertEquals("Hello World", stringOne + stringTwo);
	}

}
