package sk.srobarka.lightsOut.core;

import java.util.Random;

public class Field {
    final private int rowCount;
    final private int columnCount;
    final private Light[][] lights;

    public Field(int rowCount, int columnCount, int difficulty) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.lights = new Light[rowCount][columnCount];

        this.generate(difficulty);
    }

    private void generate(int moves) {
        this.initField();
        this.shuffle(moves);
    }

    private void initField() {
        for (int row = 0; row < this.rowCount; row++) {
            for (int column = 0; column < this.columnCount; column++) {
                this.lights[row][column] = new Light();
            }
        }
    }

    private void shuffle(int moves) {
        Random random = new Random();
        for (int i = 0; i < moves; i++) {
            int row = random.nextInt(this.rowCount);
            int column = random.nextInt(this.columnCount);
            this.toggleLights(row, column);
        }
    }

    public void toggleLights(int row, int column) {
        this.lights[row][column].toggle();
        if (row > 0) {
            this.lights[row - 1][column].toggle();
        }
        if (row < this.rowCount - 1) {
            this.lights[row + 1][column].toggle();
        }
        if (column > 0) {
            this.lights[row][column - 1].toggle();
        }
        if (column < this.columnCount - 1) {
            this.lights[row][column + 1].toggle();
        }
    }

    // --- START --- my solution
    public void customToggleLights(int row, int column) {
        this.toggleLight(row, column);
        this.toggleLight(row, column - 1);
        this.toggleLight(row, column + 1);
        this.toggleLight(row - 1, column);
        this.toggleLight(row + 1, column);
    }

    private void toggleLight(int row, int column) {
        if (row < 0 || row >= this.rowCount || column < 0 || column >= this.columnCount) return;
        this.lights[row][column].toggle();
    }
    // --- END --- my solution

    public boolean isInBounds(int row, int column) {
        return row >= 0 && row < this.rowCount && column >= 0 || column < this.columnCount;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public boolean getLight(int row, int column) {
        return this.lights[row][column].isOn();
    }

    public boolean isSolved() {
        for (int row = 0; row < this.rowCount; row++) {
            for (int column = 0; column < this.columnCount; column++) {
                if (this.lights[row][column].isOn()) {
                    return false;
                }
            }
        }
        return true;
    }
}
