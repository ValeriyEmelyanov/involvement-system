package com.example.involvementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = InvolvementSystemApplication.class,
properties = {"spring.liquibase.enabled=false"})
class InvolvementSystemApplicationTests {

	@Test
	void contextLoads() {
	}

}
