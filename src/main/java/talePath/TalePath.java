package main.java.talePath;


import java.nio.file.Path;
import java.nio.file.Paths;

public class TalePath {
    private static String taleDirectory = "tale";

    public static Path getTalePath() {
        Path thisClassDir = Paths.get(System.getProperty("user.dir"));
        return thisClassDir.getParent().getParent().resolve(taleDirectory);
    }
}
