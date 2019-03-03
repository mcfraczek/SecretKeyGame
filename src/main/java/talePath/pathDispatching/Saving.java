package main.java.talePath.pathDispatching;

import main.java.configurations.Configuration;
import main.java.talePath.TalePath;

import java.nio.file.Path;

//ok\y\c
public class Saving {
    public static void saveGame(Path talePath) {
        Path newTalePath = TalePath.getTalePath().relativize(talePath);
        Configuration.INSTANCE.getConfiguration().setSavePath(newTalePath.toString());
        Configuration.INSTANCE.saveConfiguration();
    }
}
