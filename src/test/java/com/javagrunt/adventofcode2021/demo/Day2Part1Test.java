package com.javagrunt.adventofcode2021.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class Day2Part1Test {

	Day2Part1 puzzle;

	@Autowired
	public Day2Part1Test(Day2Part1 puzzle){
		this.puzzle = puzzle;
	}

	@Test
	void test(){
		Assert.isTrue(puzzle.getAnswer().equals("150"), "Doesn't match the example provided!");
	}

}