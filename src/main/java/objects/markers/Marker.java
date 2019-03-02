package main.java.objects.markers;


import main.java.configuration.Configuration;
import main.java.configuration.ConfigurationFile;
import main.java.objects.interfaces.LineObject;

public abstract class Marker extends LineObject {
    protected ConfigurationFile configuration = Configuration.INSTANCE.getConfigurationFile();
    protected Long sleep;

    public Marker(Long sleep, int line) {
        this.sleep = sleep;
        this.line = line;
    }

    public Marker(Long sleep) {
        super();
    }
}
