package main.java;


import main.java.consoleClearing.ClearingConsole;
import main.java.consoleClearing.ClearingConsoleImpl;
import main.java.logic.GivingListOfObjects;
import main.java.objects.interfaces.ShowingObjectInterface;
import main.java.talePath.TalePath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    private static boolean imageExtention(Path path) {
        return path.toString().endsWith(".txt");
    }

    private static boolean gameExtention(Path path) {
        return path.toString().endsWith(".game");
    }

    public void tellTheTale() {
        Map<Integer, ShowingObjectInterface> objectMap = null;
        Path gamePath = null;
        Path imagePath = null;
        while (thereIsDirectory(talePath)) {
            try {
                List<Path> twoPaths = Files.walk(talePath, 1)
                        .filter(path -> imageExtention(path) || gameExtention(path)).collect(Collectors.toList());
                if (!twoPaths.isEmpty()) {
                    for (Path p : twoPaths) {
                        if (imageExtention(p)) {
                            imagePath = p;
                        } else if (gameExtention(p)) {
                            gamePath = p;
                        }
                    }
                } else {
                    scanner.close();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            objectMap = GivingListOfObjects.getTextMap(gamePath, imagePath);
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
