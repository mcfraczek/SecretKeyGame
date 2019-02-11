package main.java.consoleClearing;

import java.io.IOException;

public class ClearingConsoleImpl implements ClearingConsole {
    public void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
