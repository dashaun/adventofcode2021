package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
public class Day1Part2 implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        int counter = 0;
        int[] previousWindow = new int[3];
        int[] currentWindow = new int[3];

        // open input stream test.txt for reading purpose.
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader()
                .getResourceAsStream("input.1.1.txt"))));

        previousWindow[0] = Integer.parseInt(br.readLine());
        previousWindow[1] = Integer.parseInt(br.readLine());
        previousWindow[2] = Integer.parseInt(br.readLine());

        currentWindow[0] = previousWindow[1];
        currentWindow[1] = previousWindow[2];
        String thisLine;
        while ((thisLine = br.readLine()) != null) {
            currentWindow[2] = Integer.parseInt(thisLine);
            if (arraySum(currentWindow) > arraySum(previousWindow)) {
                counter++;
            }
            previousWindow = currentWindow.clone();
            currentWindow[0] = previousWindow[1];
            currentWindow[1] = previousWindow[2];
        }
        System.out.println("Window Increases Count: " + counter);
    }

    private int arraySum(int[] val){
        int sum = 0;
        for(int v : val){
            sum = sum + v;
        }
        return sum;
    }

}