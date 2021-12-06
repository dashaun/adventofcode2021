package com.javagrunt.adventofcode2021.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	Day1Part1 day1Part1;

	public DemoApplicationTests(Day1Part1 day1Part1){
		this.day1Part1 = day1Part1;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void Day1Part1(){
		Assert.isTrue(day1Part1.getAnswer().equals("7"), "Doesn't match the example provided!");
	}

}