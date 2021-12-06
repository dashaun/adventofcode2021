package com.javagrunt.adventofcode2021.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class Day1Part2Test {

	Day1Part2 day1Part2;

	@Autowired
	public Day1Part2Test(Day1Part2 day1Part2){
		this.day1Part2 = day1Part2;
	}

	@Test
	void Day1Part2(){
		Assert.isTrue(day1Part2.getAnswer().equals("5"), "Doesn't match the example provided!");
	}

}