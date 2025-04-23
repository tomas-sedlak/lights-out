package sk.srobarka.lightsOut;

import sk.srobarka.lightsOut.core.Field;

public class Main {
    public static void main(String[] args) {
        Field pole = new Field(5, 5, 5);

        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                System.out.print(pole.getLight(row, column) ? "\uD83D\uDCC0" : "\uD83D\uDCBF");
            }
            System.out.println();
        }
    }
}