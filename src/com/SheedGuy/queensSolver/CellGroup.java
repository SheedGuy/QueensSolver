package com.SheedGuy.queensSolver;

import java.util.ArrayList;
import java.util.List;

public class CellGroup {
    String color;
    public List<BoardCell> cells;
    int size;

    public int getSize() {
        return size;
    }

    public CellGroup(String color, BoardCell cell) {
        this.color = color;
        cells = new ArrayList<BoardCell>();
        size = 0;
        addCell(cell);
    }

//    public String getGroupByColor(com.SheedGuy.queensSolver.BoardCell) {}

    public void addCell(BoardCell cell) {
        cells.add(cell);
        size += 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Color: ").append(color).append("\n");
        for (BoardCell cell : cells) {
            sb.append(cell.toString()).append("\n");
        }
        sb.append("Size: ").append(size).append("\n");
        return sb.toString();
    }

    public List<BoardCell> getCells() {
        return cells;
    }
}
