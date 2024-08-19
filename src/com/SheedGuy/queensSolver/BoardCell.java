package com.SheedGuy.queensSolver;

import java.util.Arrays;

public class BoardCell {
    String color;
    CellValue value;
    int[] location;

    public BoardCell(String color, CellValue value, int[] location) {
        this.color = color;
        this.value = value;
        this.location = location;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public String toString() {

        return "\tCell: " + Arrays.toString(getLocation()) + "\n" +
                "\t\tColor: " + getColor() + "\n" +
                "\t\tValue: "  + getValue();
    }
}
