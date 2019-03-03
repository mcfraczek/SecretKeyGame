package main.java.talePath.pathDispatching;

import main.java.configurations.Configuration;
import main.java.talePath.TalePath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class PathFromDevConf extends PathObject {
    public PathFromDevConf() {
        path = setTalePathFromConfigurationFile();
    }

    private static Path setTalePathFromConfigurationFile() {
        String startFrom = Configuration.INSTANCE.getDevConfiguration().getStartFromThisFile();
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
}
