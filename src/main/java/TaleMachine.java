package main.java;


import main.java.consoleClearing.ClearingConsole;
import main.java.logic.GivingListOfObjects;
import main.java.objects.interfaces.ShowingObjectInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaleMachine {

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

    public static void tellTheTale(Path talePath, Scanner scanner, ClearingConsole clearingConsole) {
        Map<Integer, ShowingObjectInterface> objectMap = null;
        Path gamePath = null;
        Path imagePath = null;
        while (thereIsDirectory(talePath)) {
            clearingConsole.clearConsole();
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

            objectMap = GivingListOfObjects.getObjectsMap(gamePath, imagePath);
            for (ShowingObjectInterface object : objectMap.values()) {
                object.show();
            }
            String directory = scanner.next();
            talePath = changeTalePath(talePath, directory);
        }
        scanner.close();
    }
}
