package com.duoduo.mvnbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("hello", new App().sayHello("hello"));
	}

}
