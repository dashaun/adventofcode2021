package com.javagrunt.adventofcode2021.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class Day3Part1Test {

	Day3Part1 puzzle;

	@Autowired
	public Day3Part1Test(Day3Part1 puzzle){
		this.puzzle = puzzle;
	}

	@Test
	void test(){
		Assert.isTrue(puzzle.getAnswer().equals("198"), "Doesn't match the example provided!");
	}

}