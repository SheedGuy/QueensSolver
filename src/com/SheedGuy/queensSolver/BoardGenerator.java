package com.SheedGuy.queensSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UnknownFormatConversionException;

public class BoardGenerator {

    public BoardCell[][] createBoard(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);
        int n;
        BoardCell[][] board;

        if (sc.hasNextLine()) {
            n = Integer.parseInt(sc.nextLine());
            board = new BoardCell[n+2][n+2];
            for (int i = 0; i < n+2; i++) {
                for (int j = 0; j < n+2; j++) {
                    board[i][j] = new BoardCell("border", CellValue.X, new int[] {i, j});
                }
            }

        } else {
            throw new UnknownFormatConversionException("Invalid board file, first line must be the n, where n is the number of columns/rows in the square board");
        }

        for (int i = 1; i < n + 1; i++) {
            String line = sc.nextLine();
//            System.out.println(line);
            for (int j = 1; j < n + 1; j++) {
                board[i][j].setColor(String.valueOf(line.charAt(j - 1)));
                board[i][j].setValue(CellValue.EMPTY);
            }
        }

        return board;
    }
}
