package com.javagrunt.adventofcode2021.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class Day1Part1Test {

	Day1Part1 day1Part1;

	@Autowired
	public Day1Part1Test(Day1Part1 day1Part1){
		this.day1Part1 = day1Part1;
	}

	@Test
	void Day1Part1(){
		Assert.isTrue(day1Part1.getAnswer().equals("7"), "Doesn't match the example provided!");
	}

}