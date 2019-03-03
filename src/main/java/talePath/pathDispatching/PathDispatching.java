package main.java.talePath.pathDispatching;

import main.java.configurations.Configuration;

import java.nio.file.Path;

public class PathDispatching {
    private PathObject pathObject;

    public boolean thereIsDispatch() {
        if (devConfiguration()) {
            pathObject = new PathFromDevConf();
            return true;
        } else if (thereIsSave()) {
            pathObject = new PathFromSave();
            return true;
        }
        return false;
    }

    public Path dispatchedTalePath() {
        return pathObject.getPath();
    }


    private boolean thereIsSave() {
        return !Configuration.INSTANCE.getConfiguration().getSavePath().equals("default");
    }

    private boolean devConfiguration() {
        return !Configuration.INSTANCE.getDevConfiguration().getStartFromThisFile().equals("default");
    }

}
