package main.java;


import main.java.consoleClearing.ClearingConsole;
import main.java.logic.GivingListOfObjects;
import main.java.objects.interfaces.ShowingObjectInterface;
import main.java.talePath.PathEstabishing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

public class TaleMachine {
    private static boolean thereIsDirectory(Path talePath) {
        return !Files.notExists(talePath);
    }

    private static Path changeTalePath(Path talePath, String directory) {
        return talePath.resolve(directory);
    }

    public static void tellTheTale(Path talePath, Scanner scanner, ClearingConsole clearingConsole) {
        Map<Integer, ShowingObjectInterface> objectMap = null;
        boolean back = false;
        while (thereIsDirectory(talePath)) {
            Path gamePath = null;
            Path imagePath = null;
            Path choicePath = null;
            clearingConsole.clearConsole();
            PathEstabishing pathEstabishing = new PathEstabishing(talePath).invoke();
            if (!back) {
                gamePath = pathEstabishing.getGamePath();
            }
            imagePath = pathEstabishing.getImagePath();
            choicePath = pathEstabishing.getChoicePath();

            objectMap = GivingListOfObjects.getObjectsMap(gamePath, imagePath, choicePath);

            for (ShowingObjectInterface object : objectMap.values()) {
                object.show();
            }
            String answer = scanner.next();
            if (answer.trim().equals("back")) {
                talePath = talePath.getParent();
                back = true;
                continue;
            }
            talePath = changeTalePath(talePath, answer);
        }
        scanner.close();
    }
}
