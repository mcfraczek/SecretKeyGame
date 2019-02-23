package main.java.logic.services.objectServices.patternFactory;

import java.util.regex.Pattern;

public enum PatternFactory {
    LINE_SLEEP("\\[\\d+]", "\\[(\\d+)\\]"),
    WORD_SLEEP("<t=\\d+>.*?<>", "<t=(\\d+)>(.*?)<>");
    private Pattern general;
    private Pattern details;

    PatternFactory(String general, String details) {
        this.general = Pattern.compile(general);
        this.details = Pattern.compile(details);
    }

    public Pattern getGeneral() {
        return general;
    }

    public Pattern getDetails() {
        return details;
    }
}
