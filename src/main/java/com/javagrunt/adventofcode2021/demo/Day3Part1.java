package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
public class Day3Part1 implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(
                        this.getClass().getClassLoader()
                                .getResourceAsStream("input.3.1.txt"))));
        //Assume the file has a line to start with
        String thisLine;
        thisLine = br.readLine();

        int[] ones = new int[thisLine.length()];
        int[] zeros = new int[thisLine.length()];

        for(int pos = 0;  pos < thisLine.length(); pos ++){
            if(thisLine.charAt(pos) == '1'){
                ones[pos]++;
            }else if(thisLine.charAt(pos) == '0'){
                zeros[pos]++;
            }else{
                System.err.println("This shouldn't happen");
            }
        }

        while ((thisLine = br.readLine()) != null) {
            for(int pos = 0;  pos < thisLine.length(); pos ++){
                if(thisLine.charAt(pos) == '1'){
                    ones[pos]++;
                }else if(thisLine.charAt(pos) == '0'){
                    zeros[pos]++;
                }else{
                    System.err.println("This shouldn't happen");
                }
            }
        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for(int pos = 0; pos < ones.length ; pos++){
            if(ones[pos] > zeros[pos]){
                gamma.append("1");
                epsilon.append("0");
            }else{
                gamma.append("0");
                epsilon.append("1");
            }
        }
        System.out.println(this.getClass().getSimpleName() + " :: Gamma   " + gamma);
        int gammaInt = Integer.parseInt(gamma.toString(), 2);
        System.out.println(this.getClass().getSimpleName() + " :: Gamma as decimal " + gammaInt);
        System.out.println(this.getClass().getSimpleName() + " :: Epsilon " + epsilon);
        int epsilonInt = Integer.parseInt(epsilon.toString(), 2);
        System.out.println(this.getClass().getSimpleName() + " :: Epsilon as decimal " + epsilonInt);

        int power = gammaInt * epsilonInt;
        System.out.println(this.getClass().getSimpleName() + " :: Power   " + power);
    }
}