package main.java;

import main.java.consoleClearing.ClearingConsole;
import main.java.consoleClearing.ClearingConsoleImpl;
import main.java.talePath.TalePath;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClearingConsole clearingConsole = new ClearingConsoleImpl();
        Path talePath = TalePath.getTalePath();
        Scanner scanner = new Scanner(System.in);
        TaleMachine.tellTheTale(talePath, scanner, clearingConsole);
    }
}
