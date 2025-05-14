package sk.srobarka.lightsOut;

import sk.srobarka.lightsOut.consoleUI.ConsoleUI;
import sk.srobarka.lightsOut.core.Field;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(5, 5, 3);
        ConsoleUI consoleUI = new ConsoleUI(field);
        consoleUI.play();
    }
}