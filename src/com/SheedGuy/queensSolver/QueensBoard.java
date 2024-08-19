package com.SheedGuy.queensSolver;

import java.io.FileNotFoundException;
import java.util.*;

public class QueensBoard {
    HashMap<String, CellGroup> colorGroups;
    BoardCell[][] board;
    int n;
    BoardGenerator generator = new BoardGenerator();

    public QueensBoard(String filePath) throws FileNotFoundException {
        board = generator.createBoard(filePath);
        n = board.length - 2;
        colorGroups = getColorGroups(board);
    }

    public HashMap<String, CellGroup> getColorGroups(BoardCell[][] board) {
        HashMap<String, CellGroup> groups  = new HashMap<String, CellGroup>();

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (groups.containsKey(board[i][j].getColor())) {
                    groups.get(board[i][j].getColor()).addCell(board[i][j]);
                } else {
                    groups.put(board[i][j].getColor(), new CellGroup(board[i][j].getColor(), board[i][j]));
                }
            }
        }

        return groups;
    }

    public void setTileToX(int x, int y) {
        board[x][y].setValue(CellValue.X);
    }

    public void setTileToCrown(int x, int y) {
        board[x][y].setValue(CellValue.CROWN);
    }

    public void setTileToEmpty(int x, int y) {
        board[x][y].setValue(CellValue.EMPTY);
    }

    public boolean isValidSolution() {
        return checkRows() && checkColumns();
    }

    public boolean checkRows() {
        for (int i = 1; i < n+1; i++) {
            int crowns = 0;
            for (int j = 1; j < n+1; j++) {
                if (board[i][j].getValue() == CellValue.CROWN) {
                    crowns++;
                    if (!checkSurrounding(i, j)) {
                        return false;
                    }
                }
            }
            if (crowns != 1) return false;
        }
        return true;
    }

    public boolean checkColumns() {
        for (int i = 1; i < n+1; i++) {
            int crowns = 0;
            for (int j = 1; j < n+1; j++) {
                if (board[j][i].getValue() == CellValue.CROWN) {
                    crowns++;
                    if (!checkSurrounding(j, i)) {
                        return false;
                    }
                }
            }
            if (crowns != 1) return false;
        }
        return true;
    }

    public boolean checkSurrounding(int x, int y) {
        if (board[x-1][y-1].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x][y-1].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x+1][y-1].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x-1][y].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x+1][y].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x-1][y+1].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x][y+1].getValue() == CellValue.CROWN) {
            return false;
        } else if (board[x+1][y+1].getValue() == CellValue.CROWN) {
            return false;
        } else {
            return true;
        }
    }


    public void printBoard() {
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                System.out.print(board[i][j].getColor() + " ");
            }
            System.out.println();
        }
    }

    public void printValues() {
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                switch (board[i][j].getValue()) {
                    case X:
                        System.out.print("X ");
                        break;
                    case CROWN:
                        System.out.print("C ");
                        break;
                    case EMPTY:
                        System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void printColorGroups() {
        for (CellGroup group : colorGroups.values()) {
            System.out.println(group);
        }
    }

    public String[] sortColorGroupsBySize(HashMap<String, CellGroup> colorGroups) {
        // Convert HashMap values to a List
        List<CellGroup> groupList = new ArrayList<>(colorGroups.values());

        // Sort the list based on com.SheedGuy.queensSolver.CellGroup size
        groupList.sort(Comparator.comparingInt(CellGroup::getSize));

        // Create a new array with the same size as the number of color groups
        String[] sortedColors = new String[colorGroups.size()];

        // Fill the array with colors in the sorted order
        for (int i = 0; i < groupList.size(); i++) {
            sortedColors[i] = groupList.get(i).color;
        }

        return sortedColors;
    }
}
