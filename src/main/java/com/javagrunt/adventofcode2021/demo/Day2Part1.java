package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
public class Day2Part1 extends AdventOfCodePuzzle implements InitializingBean {

    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";

    @Override
    public void afterPropertiesSet() throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(
                        this.getClass().getClassLoader()
                                .getResourceAsStream("input.2.1.txt"))));

        int horizontalPosition = 0;
        int depth = 0;
        String thisLine;
        while ((thisLine = br.readLine()) != null) {
            if(thisLine.startsWith(FORWARD)){
                horizontalPosition = horizontalPosition + Integer.parseInt(thisLine.substring(FORWARD.length() + 1));
            } else if (thisLine.startsWith(DOWN)){
               depth = depth + Integer.parseInt(thisLine.substring(DOWN.length() + 1));
            } else if (thisLine.startsWith(UP)){
                depth = depth - Integer.parseInt(thisLine.substring(UP.length() + 1));
            } else {
                System.err.println("THIS SHOULD NOT HAPPEN");
            }
        }
        int answer = horizontalPosition * depth;
        setAnswer(String.valueOf(answer));
    }
}