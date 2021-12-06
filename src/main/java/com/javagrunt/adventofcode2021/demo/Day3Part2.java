package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Day3Part2 extends AdventOfCodePuzzle implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        String ogr = oxygenGeneratorRating(readIntoList(), 0);
        String csr = co2ScrubberRating(readIntoList(), 0);
        int ogrInt = Integer.parseInt(ogr, 2);
        int csrInt = Integer.parseInt(csr,2);
        setAnswer(String.valueOf(ogrInt * csrInt));
    }

    private List<String> readIntoList() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(
                        this.getClass().getClassLoader()
                                .getResourceAsStream("input.3.1.txt"))));

        String thisLine;
        thisLine = br.readLine();

        ArrayList<String> diagnosticData = new ArrayList<>();
        diagnosticData.add(thisLine);

        while ((thisLine = br.readLine()) != null) {
            diagnosticData.add(thisLine);
        }
        return diagnosticData;
    }

    private String co2ScrubberRating(List<String> input, int index){
        int ones = 0;
        int zeros = 0;

        for(String i: input){
            if(i.charAt(index) == '1'){
                ones+=1;
            }else{
                zeros+=1;
            }
        }

        List<String> filtered = new ArrayList<>();
        if (zeros <= ones) {
            for (String i : input) {
                if (i.charAt(index) == '0') {
                    filtered.add(i);
                }
            }
        } else {
            for (String i : input) {
                if (i.charAt(index) == '1') {
                    filtered.add(i);
                }
            }
        }

        if (filtered.size() == 1) {
            return filtered.get(0);
        } else {
            return co2ScrubberRating(filtered, index + 1);
        }
    }

    private String oxygenGeneratorRating(List<String> input, int index) {
        int ones = 0;
        int zeros = 0;

        for(String i: input){
            if(i.charAt(index) == '1'){
               ones+=1;
            }else{
                zeros+=1;
            }
        }

        List<String> filtered = new ArrayList<>();
        if (ones >= zeros) {
            for (String i : input) {
                if (i.charAt(index) == '1') {
                    filtered.add(i);
                }
            }
        } else {
            for (String i : input) {
                if (i.charAt(index) == '0') {
                    filtered.add(i);
                }
            }
        }

        if (filtered.size() == 1) {
            return filtered.get(0);
        } else {
            return oxygenGeneratorRating(filtered, index + 1);
        }
    }
}