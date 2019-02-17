package main.java.logic;


import main.java.logic.services.objectServices.markedLine.LineSleeepServiceLine;
import main.java.logic.services.objectServices.markedLine.MarkedLineObjectService;
import main.java.logic.services.reading.PictureReadingService;
import main.java.logic.services.reading.ReadingService;
import main.java.logic.services.reading.TextReadingService;
import main.java.objects.Picture;
import main.java.objects.Text;
import main.java.objects.interfaces.ShowingObjectInterface;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GivingListOfObjects {

    public static Map<Integer, ShowingObjectInterface> getObjectsMap(Path gamePath, Path imagePath, Path choicePath) {
        Map<Integer, ShowingObjectInterface> map = new TreeMap<>();
        List<String> imageLines = null;
        List<String> gameLines = null;
        List<String> choiceLines = null;

        ReadingService imageReading = new PictureReadingService();
        ReadingService gameReading = new TextReadingService();
        int iteratorStart = 0;
        if (imagePath != null) {
            imageLines = imageReading.read(imagePath);
            iteratorStart = checkForImageObjects(imageLines, map, iteratorStart);
        }
        if (gamePath != null) {
            gameLines = gameReading.read(gamePath);
            iteratorStart = checkForGameObjects(gameLines, map, iteratorStart);
        }
        if (choicePath != null) {
            choiceLines = gameReading.read(choicePath);
            iteratorStart = checkForChoiceObjects(choiceLines, map, iteratorStart);
        }

        return map;
    }

    private static int checkForChoiceObjects(List<String> choiceLines, Map<Integer, ShowingObjectInterface> map, int iteratorStart) {
        return checkForGameObjects(choiceLines, map, iteratorStart);
    }

    private static int checkForImageObjects(List<String> lines, Map<Integer, ShowingObjectInterface> map, int iteratorStart) {
        MarkedLineObjectService lineSleeepService = new LineSleeepServiceLine();

        for (String line : lines) {
            if (lineSleeepService.thereIsAMark(line)) {
                map.put(iteratorStart, lineSleeepService.changeMarkedIntoObject(line, iteratorStart));
            } else {
                map.put(iteratorStart, new Picture(line, iteratorStart));
            }
            iteratorStart++;
        }
        return iteratorStart;
    }

    private static int checkForGameObjects(List<String> lines, Map<Integer, ShowingObjectInterface> map, int iteratorStart) {
        MarkedLineObjectService lineSleeepService = new LineSleeepServiceLine();
        for (String line : lines) {
            if (lineSleeepService.thereIsAMark(line)) {
                map.put(iteratorStart, lineSleeepService.changeMarkedIntoObject(line, iteratorStart));
                iteratorStart++;
            } else { // normal line
                map.put(iteratorStart, new Text(line, iteratorStart));
                iteratorStart++;
            }
        }
        return iteratorStart;
    }
}
