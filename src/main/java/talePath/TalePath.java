package main.java.talePath;


import java.nio.file.Path;
import java.nio.file.Paths;

public class TalePath {
    public static final Path userDir = Paths.get(System.getProperty("user.dir"));
    private static String taleDirectory = "tale";

    public static Path getTalePath() {
        return userDir.getParent().resolve(taleDirectory);
    }
}
