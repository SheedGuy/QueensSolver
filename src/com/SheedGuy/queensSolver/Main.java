package com.SheedGuy.queensSolver;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        String filePath = args.length > 0 ? args[0] : "src/ExampleBoards/8-19-24.txt";
        QueensBoard board;

        try {
            board = new QueensBoard(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        RecBF recBF = new RecBF(board);
        recBF.solve();
    }
}