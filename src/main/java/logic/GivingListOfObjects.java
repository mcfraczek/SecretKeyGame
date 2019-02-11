package main.java.logic;


import main.java.logic.services.objectServices.LineSleeepService;
import main.java.logic.services.objectServices.MarkedObjectService;
import main.java.logic.services.reading.ReadingService;
import main.java.logic.services.reading.TextReadingService;
import main.java.objects.Text;
import main.java.objects.interfaces.ShowingObjectInterface;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GivingListOfObjects {

    public static Map<Integer, ShowingObjectInterface> getObjectMap(Path talePath) {
        Map<Integer, ShowingObjectInterface> map = new TreeMap<>();
        ReadingService readingService = new TextReadingService();
        List<String> lines = readingService.read(talePath);
        checkForObjects(lines, map);
        return map;
    }

    private static void checkForObjects(List<String> lines, Map<Integer, ShowingObjectInterface> map) {
        MarkedObjectService lineSleeepService = new LineSleeepService();
        for (int i = 0; i < lines.size(); i++) {
            if (lineSleeepService.thereIsAMark(lines.get(i))) {
                map.put(i, lineSleeepService.changeMarkedIntoObject(lines.get(i), i));
            } else{
                map.put(i, new Text(lines.get(i), i));
            }
        }
    }


}
