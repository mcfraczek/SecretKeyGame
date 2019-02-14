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

        while (thereIsDirectory(talePath)) {
            clearingConsole.clearConsole();
            PathEstabishing pathEstabishing = new PathEstabishing(talePath).invoke();
            Path gamePath = pathEstabishing.getGamePath();
            Path imagePath = pathEstabishing.getImagePath();
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
