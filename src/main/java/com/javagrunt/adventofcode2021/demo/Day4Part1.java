package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Day4Part1 extends AdventOfCodePuzzle implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        readInput("input.4.1.txt");
        String[] draws = getData().get(0).split(",");

    }
}
class Board {
    int[] rows = new int[5];
    int[] cols = new int[5];
}