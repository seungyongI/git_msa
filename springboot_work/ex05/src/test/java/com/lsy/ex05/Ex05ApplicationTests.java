package com.lsy.ex05;

import com.lsy.ex05.obj.AA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ex05ApplicationTests {

	@Autowired
	public AA aa;

	@Test
	void contextLoads() {
		aa.doA();
	}

}
