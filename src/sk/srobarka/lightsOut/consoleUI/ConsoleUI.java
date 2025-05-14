package sk.srobarka.lightsOut.consoleUI;

import sk.srobarka.lightsOut.core.Field;

import java.util.Scanner;

public class ConsoleUI {
    final private Field field;
    final private Scanner scanner;

    private boolean stop;
    private int attempts;

    public ConsoleUI(Field field) {
        this.field = field;
        this.scanner = new Scanner(System.in);

        this.stop = false;
        this.attempts = 0;
    }

    public void play() {
        while (!this.stop) {
            if (this.field.isSolved()) {
                System.out.println("VYHRAL SI!");
                this.stop = true;
            }
            this.draw();
            this.processInput();
        }
    }

    private void draw() {
        for (int row = 0; row < this.field.getRowCount(); row++) {
            for (int column = 0; column < this.field.getColumnCount(); column++) {
                String output = this.field.getLight(row, column) ? "\uD83D\uDCC0" : "\uD83D\uDCBF";
                System.out.print(output);
            }
            System.out.println();
        }
    }

    private void processInput() {
        System.out.print("Zadaj vstup: ");

        String[] input = scanner.nextLine().trim().toLowerCase().split(" ");
        
        switch(input[0]) {
            case "koniec":
            case "k":
                System.out.println("Natvrdo si stopol hru.");
                stop = true;
                break;
            case "prepni":
            case "p":
                try {
                    int row = Integer.parseInt(input[1]) - 1;
                    int column = Integer.parseInt(input[2]) - 1;

                    if (this.field.isInBounds(row, column)) {
                        this.field.toggleLights(row, column);
                        this.attempts += 1;
                    } else {
                        System.out.println("Pozicia mimo hracej plochy.");
                    }
                } catch (Exception e) {
                    System.out.println("Nespravne zadane cisla.");
                }
                break;
            default:
                System.out.println("Taky prikaz nepoznam!");
                break;
        }
    }
}
