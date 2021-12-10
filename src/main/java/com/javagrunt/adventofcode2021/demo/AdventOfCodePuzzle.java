package com.javagrunt.adventofcode2021.demo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdventOfCodePuzzle {
    private String answer;
    private List<String> data;

    public void readInput() throws IOException, URISyntaxException {
        data = Files.readAllLines(Paths.get(ClassLoader.getSystemResource(this.getClass().getSimpleName() + ".txt").toURI()));
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