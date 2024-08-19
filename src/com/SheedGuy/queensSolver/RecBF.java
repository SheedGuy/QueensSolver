package com.SheedGuy.queensSolver;

import java.util.HashMap;

public class RecBF {
    public QueensBoard board;
    public String[] sortedColorGroupsIndex;
    public HashMap<String, CellGroup> colorGroups;

    public RecBF(QueensBoard board) {
        this.board = board;
        colorGroups = board.colorGroups;
        sortedColorGroupsIndex = board.sortColorGroupsBySize(colorGroups);
    }

    public void solve() {
        QueensBoard solution = backtrack(0, board);
        solution.printValues();
    }

    public QueensBoard backtrack(int index, QueensBoard currentBoard) {

        if (index == currentBoard.colorGroups.size() - 1) {

            for (BoardCell cell : colorGroups.get(sortedColorGroupsIndex[index]).cells) {
                int[] cellLocation  = cell.location;
                currentBoard.setTileToCrown(cellLocation[0], cellLocation[1]);
//                currentBoard.printValues();
                if (currentBoard.isValidSolution()) {
                    return currentBoard;
                }
                currentBoard.setTileToEmpty(cellLocation[0], cellLocation[1]);
            }

            return null;
        }

        for (BoardCell cell : colorGroups.get(sortedColorGroupsIndex[index]).cells) {
            int[] cellLocation  = cell.location;
            currentBoard.setTileToCrown(cellLocation[0], cellLocation[1]);
            QueensBoard solution = backtrack(index+1, currentBoard);
            if (solution != null) {
                return solution;
            }
            currentBoard.setTileToEmpty(cellLocation[0], cellLocation[1]);
        }

        return null;
    }
}
