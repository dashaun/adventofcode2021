package com.javagrunt.adventofcode2021.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCodePuzzle {
    private String answer;
    private List<String> data;

    public void readInput(String filename) throws IOException, URISyntaxException {
        data = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(filename).toURI()));
    }

    public List<String> getData(){
        return this.data;
    }

    public void setAnswer(String answer){
        this.answer = answer;
        System.out.println(this.getClass().getSimpleName()+ " :: " + getAnswer());
    }

    public String getAnswer(){
        return this.answer;
    }
}