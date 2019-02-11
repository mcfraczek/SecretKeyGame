package main.java.logic.services.objectServices.markedLetter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleLetterSleepService implements MarkedLetterObjectService {
    @Override
    public boolean thereIsAMark(String line) {
        Pattern pattern = Pattern.compile("<t=(\\d+)>\\w+<>");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeMarkedIntoObject(String line, int iteratorStart) {

    }
}
