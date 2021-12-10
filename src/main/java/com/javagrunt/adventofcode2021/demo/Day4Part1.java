package com.javagrunt.adventofcode2021.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Day4Part1 extends AdventOfCodePuzzle implements InitializingBean {
    List<Board> boards;

    @Override
    public void afterPropertiesSet() throws Exception {
        readInput();
        String[] draws = getData().get(0).split(",");
        getData().remove(0);
        loadBoards(getData());
        drawNumbers(draws);
    }

    private void drawNumbers(String[] draws) {
        for (String draw : draws) {
            if(null != getAnswer()){
                continue;
            }
            //System.out.println("Draw::" + draw);
            for (Board board : boards) {
                int index = board.getNumbers().indexOf(draw);
                if (index > -1) {
                    //The draw is on this board
                    //Flip the status bit
                    int bitToFlip = (int) Math.pow(2, index);
                    board.setStatus(board.getStatus() | bitToFlip);
                }
            }
            checkWinners(Integer.parseInt(draw));
        }
    }

    private void checkWinners(int draw) {
        for (Board board : boards) {
            if(null != getAnswer()){
                continue;
            }
            int status = board.getStatus();
            //System.out.println("Board:  " + board.getNumbers().stream().toList());
            //System.out.println("Status: " + Integer.toBinaryString(status));
            int checkRow = ((int) Math.pow(2, 5) - 1);
            int checkCol = (int) (Math.pow(2, 19) + Math.pow(2, 14) + Math.pow(2, 9) + Math.pow(2, 4) + Math.pow(2, 0));
            String checkColStr = Integer.toBinaryString(checkCol);
            //System.out.println("Check:  " + checkColStr);
            //Checking the rows for winners
            for (int i = 0; i < 5; i++) {
                int shifted = status >> (5 * i);
                int result = shifted & checkRow;
                //System.out.println("After:  " + Integer.toBinaryString(result));
                if (result == checkRow) {
                    winnerFound(board, draw);
                    continue;
                }
                shifted = checkCol << (i);
                result = shifted & status;
                String resultStr = Integer.toBinaryString(result);
                if (resultStr.contains(checkColStr)) {
                    winnerFound(board, draw);
                }
            }
        }
    }

    private void winnerFound(Board board, int draw){
        System.out.println("Board: " + board.getNumbers());
        System.out.println("Status:" + Integer.toBinaryString(board.getStatus()));
        System.out.println("Draw:  " + draw);
        int sumOfUnflipped = 0;
        for(int i = 0; i<24; i++){
            int shifted = board.getStatus() >> i;
            //System.out.println("Shifted:" + Integer.toBinaryString(shifted));
            if(shifted % 2 == 0){
                sumOfUnflipped = sumOfUnflipped + Integer.parseInt(board.getNumbers().get(i));
            }
        }
//        System.out.println("SumOfUnflipped: " + sumOfUnflipped);
        setAnswer("" + (draw * sumOfUnflipped));
    }

    private void loadBoards(List<String> data) throws CloneNotSupportedException {
        boards = new ArrayList<>();
        Board board = new Board();
        for (String thisLine : data) {
            if (thisLine.isEmpty()) {
                continue;
            }

            if (board.getNumbers().size() >= 25) {
                boards.add(board.clone());
                board = new Board();
            }
            board.getNumbers().addAll(split(thisLine));
        }
        boards.add(board.clone());
    }

    private List<String> split(String thisLine) {
        return Arrays.stream(thisLine.split("[ ]+"))
                .filter(l -> !l.isEmpty())
                .toList();
    }
}

class Board implements Cloneable {
    private final ArrayList<String> numbers;
    private int status;

    public Board() {
        this.numbers = new ArrayList<>();
        this.status = (int) Math.pow(2, 24);
    }

    @Override
    protected Board clone() throws CloneNotSupportedException {
        return (Board) super.clone();
    }

    public ArrayList<String> getNumbers() {
        return this.numbers;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}