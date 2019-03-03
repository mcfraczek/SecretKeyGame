package main.java.talePath.pathDispatching;

import main.java.configurations.Configuration;
import main.java.talePath.TalePath;

import java.nio.file.Path;

public class PathFromSave extends PathObject {
    public PathFromSave() {
        path = getSavePath();
    }

    private static Path getSavePath() {
        String savePath = Configuration.INSTANCE.getConfiguration().getSavePath();
        return TalePath.getTalePath().resolve(savePath);
    }
}
