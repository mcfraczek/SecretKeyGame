package main.java.talePath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class PathEstabishing {
    private Path talePath;
    private Path gamePath;
    private Path imagePath;

    public PathEstabishing(Path talePath) {
        this.talePath = talePath;
    }

    private static boolean imageExtention(Path path) {
        return path.toString().endsWith(".txt");
    }

    private static boolean gameExtention(Path path) {
        return path.toString().endsWith(".game");
    }

    public Path getGamePath() {
        return gamePath;
    }

    public Path getImagePath() {
        return imagePath;
    }

    public PathEstabishing invoke() {
        try {
            List<Path> twoPaths = Files.walk(talePath, 1)
                    .filter(path -> imageExtention(path) || gameExtention(path))
                    .collect(Collectors.toList());
            for (Path p : twoPaths) {
                if (imageExtention(p)) {
                    imagePath = p;
                } else if (gameExtention(p)) {
                    gamePath = p;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}