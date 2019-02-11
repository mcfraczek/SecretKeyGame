package main.java;


import main.java.consoleClearing.ClearingConsole;
import main.java.consoleClearing.ClearingConsoleImpl;
import main.java.logic.GivingListOfObjects;
import main.java.objects.interfaces.ShowingObjectInterface;
import main.java.talePath.TalePath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class TaleMachine {
    private ClearingConsole clearingConsole = new ClearingConsoleImpl();
    private Path talePath = TalePath.getTalePath();
    private Scanner scanner = new Scanner(System.in);

    private static boolean thereIsDirectory(Path talePath) {
        return !Files.notExists(talePath);
    }

    private static Path changeTalePath(Path talePath, String directory) {
        return talePath.resolve(directory);
    }

    private static boolean txtExtention(Path path) {
        return path.toString().endsWith(".txt");
    }

    public void tellTheTale() {
        Map<Integer, ShowingObjectInterface> objectMap = null;
        Path first = null;
        while (thereIsDirectory(talePath)) {
            try {
                Optional<Path> firstOptional = Files.walk(talePath, 1)
                        .filter(TaleMachine::txtExtention).findFirst();
                if (firstOptional.isPresent()) {
                    first = firstOptional.get();
                } else {
                    scanner.close();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            objectMap = GivingListOfObjects.getObjectMap(first);
            for (ShowingObjectInterface value : objectMap.values()) {
                value.show();
            }
            String directory = scanner.next();
            talePath = changeTalePath(talePath, directory);
            clearingConsole.clearConsole();
        }
        scanner.close();

    }
}
