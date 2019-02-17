package main.java.talePath;


import java.nio.file.Path;
import java.nio.file.Paths;

public class TalePath {
    private static String taleDirectory = "tale";
    public static final Path userDir = Paths.get(System.getProperty("user.dir")).getParent().getParent();

    public static Path getTalePath() {
        return userDir.resolve(taleDirectory);
    }
}
