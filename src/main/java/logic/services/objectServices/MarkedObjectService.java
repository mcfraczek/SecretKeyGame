package main.java.logic.services.objectServices;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface MarkedObjectService {
    boolean thereIsAMark(String line);

    default boolean findThisPattern(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group() != null) {
                return true;
            }
        }
        return false;
    }
}
