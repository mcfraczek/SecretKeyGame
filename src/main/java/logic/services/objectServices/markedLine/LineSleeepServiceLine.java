package main.java.logic.services.objectServices.markedLine;


import main.java.logic.services.objectServices.patternFactory.PatternFactory;
import main.java.objects.interfaces.ShowingObjectInterface;
import main.java.objects.markers.SleepMarker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineSleeepServiceLine implements MarkedLineObjectService {
    @Override
    public boolean thereIsAMark(String line) {
        return line.trim().matches(PatternFactory.LINE_SLEEP.getGeneral().toString());
    }

    public ShowingObjectInterface changeMarkedIntoObject(String line, int lineNumber) {
        long howLong = 0;
        Pattern pattern = PatternFactory.LINE_SLEEP.getDetails();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            howLong = Long.parseLong(matcher.group(1));
        }
        return new SleepMarker(howLong, lineNumber);
    }
}
