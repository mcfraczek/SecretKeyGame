package main.java.logic.services.objectServices.markedInterfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface GeneralMarkService {
    static boolean findThisPattern(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group() != null) {
                return true;
            }
        }
        return false;
    }
}
