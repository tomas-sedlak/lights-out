package sk.srobarka.lightsOut.core;

public class Field {
    private int rowCount;
    private int columnCount;
    private Light[][] lights;

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
        for (int i = 0; i < moves; i++) {
            int row = (int) (Math.random() * this.rowCount);
            int column = (int) (Math.random() * this.columnCount);
            this.click(row, column);
        }
    }

    public void click(int row, int column) {
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

    public boolean getLight(int row, int column) {
        return this.lights[row][column].isOn();
    }
}
