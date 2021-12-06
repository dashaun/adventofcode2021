package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
public class Day1Part1 extends AdventOfCodePuzzle implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        int counter = 0;
        int previousValue;
        int currentValue;
        String filename = "input.1.1.txt";
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader()
                .getResourceAsStream(filename))));

        previousValue = Integer.parseInt(br.readLine());
        String thisLine;
        while ((thisLine = br.readLine()) != null) {
            currentValue = Integer.parseInt(thisLine);
            if (currentValue > previousValue) {
                counter++;
            }
            previousValue = currentValue;
        }
        setAnswer(String.valueOf(counter));
    }

}