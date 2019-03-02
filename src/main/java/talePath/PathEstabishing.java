package main.java.talePath;

import main.java.configuration.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PathEstabishing {
    private Path talePath;
    private Path gamePath;
    private Path imagePath;
    private Path choicePath;

    public PathEstabishing(Path talePath) {
        this.talePath = talePath;
    }

    private static boolean imageExtention(Path path) {
        return path.toString().endsWith(".image");
    }

    private static boolean gameExtention(Path path) {
        return path.toString().endsWith(".game");
    }

    private static boolean choiceExtention(Path path) {
        return path.toString().endsWith(".choice");
    }

    public static Path setTalePathFromConfigurationFile() {
        String startFrom = Configuration.INSTANCE.getConfigurationClass().getStartFromThisFile();
        Path talePath = TalePath.getTalePath();
        Path returningPath = null;
        try {
            Optional<Path> first = Files.walk(talePath).filter(p -> p.getFileName().toString().equals(startFrom)).findFirst();
            if (first.isPresent()) {
                returningPath = first.get().getParent();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return returningPath;
    }

    public Path getChoicePath() {
        return choicePath;
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
                    .filter(path -> imageExtention(path) || gameExtention(path) || choiceExtention(path))
                    .collect(Collectors.toList());
            for (Path p : twoPaths) {
                if (imageExtention(p)) {
                    imagePath = p;
                } else if (gameExtention(p)) {
                    gamePath = p;
                } else if (choiceExtention(p)) {
                    choicePath = p;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
