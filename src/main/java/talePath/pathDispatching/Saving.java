package main.java.talePath.pathDispatching;

import main.java.configurations.Configuration;
import main.java.talePath.TalePath;

import java.nio.file.Path;

public class Saving {
    public static void saveGame(Path talePath) {
        Path newTalePath = TalePath.getTalePath().relativize(talePath);
        Configuration.INSTANCE.getConfiguration().setSavePath(newTalePath.toString());
        Configuration.INSTANCE.saveConfiguration();
    }

    public static void deleteSave() {
        Configuration.INSTANCE.getConfiguration().setSavePath("default");
        Configuration.INSTANCE.saveConfiguration();
    }
}
