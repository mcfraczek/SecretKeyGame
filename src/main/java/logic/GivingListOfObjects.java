package main.java.logic;


import main.java.logic.services.objectServices.markedLetter.MarkedLetterObjectService;
import main.java.logic.services.objectServices.markedLetter.SingleLetterSleepService;
import main.java.logic.services.objectServices.markedLine.LineSleeepServiceLine;
import main.java.logic.services.objectServices.markedLine.MarkedLineObjectService;
import main.java.logic.services.reading.PictureReadingService;
import main.java.logic.services.reading.ReadingService;
import main.java.logic.services.reading.TextReadingService;
import main.java.objects.Text;
import main.java.objects.interfaces.ShowingObjectInterface;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GivingListOfObjects {

    public static Map<Integer, ShowingObjectInterface> getObjectsMap(Path gamePath, Path imagePath) {
        Map<Integer, ShowingObjectInterface> map = new TreeMap<>();

        ReadingService imageReading = new PictureReadingService();
        ReadingService gameReading = new TextReadingService();

        List<String> imageLines = imageReading.read(imagePath);
        List<String> gameLines = gameReading.read(gamePath);

        int iteratorStart = 0;
        checkForGameObjects(gameLines, map, checkForImageObjects(imageLines, map, iteratorStart));

        return map;
    }

    private static int checkForImageObjects(List<String> lines, Map<Integer, ShowingObjectInterface> map, int iteratorStart) {
        MarkedLineObjectService lineSleeepService = new LineSleeepServiceLine();

        for (String line : lines) {
            if (lineSleeepService.thereIsAMark(line)) {
                map.put(iteratorStart, lineSleeepService.changeMarkedIntoObject(line, iteratorStart));
            } else {
                map.put(iteratorStart, new Text(line, iteratorStart));
            }
            iteratorStart++;
        }
        return iteratorStart;
    }

    private static int checkForGameObjects(List<String> lines, Map<Integer, ShowingObjectInterface> map, int iteratorStart) {
        MarkedLineObjectService lineSleeepService = new LineSleeepServiceLine();
        MarkedLetterObjectService singleLetterSleepService = new SingleLetterSleepService();
        for (String line : lines) {
            if (singleLetterSleepService.thereIsAMark(line)) {
                singleLetterSleepService.changeMarkedIntoObject(line, iteratorStart);
//wziać linię, wiąć iterator i mapę, albo zwrócić kolekcje. Dodawać Obiekt, pomiędzy dodawać
                //obiekt zwykłej linii. Nie mam innego pomysłu
                iteratorStart++;
            } else if (!lineSleeepService.thereIsAMark(line)) {
                map.put(iteratorStart, new Text(line, iteratorStart));
                iteratorStart++;

            } else if (lineSleeepService.thereIsAMark(line)) {
                map.put(iteratorStart, lineSleeepService.changeMarkedIntoObject(line, iteratorStart));
                iteratorStart++;
            }
        }
        return iteratorStart;
    }
}
