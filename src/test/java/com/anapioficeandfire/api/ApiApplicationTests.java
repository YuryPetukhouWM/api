package com.anapioficeandfire.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan("com.anapioficeandfire.api.model.entity")
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
