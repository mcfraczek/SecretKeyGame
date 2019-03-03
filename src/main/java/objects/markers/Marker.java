package main.java.objects.markers;


import main.java.configurations.devConfiguration.DevConfiguration;
import main.java.configurations.devConfiguration.DevConfigurationClass;
import main.java.objects.interfaces.LineObject;

public abstract class Marker extends LineObject {
    protected DevConfigurationClass configuration = DevConfiguration.INSTANCE.getDevConfigurationClass();
    protected Long sleep;

    public Marker(Long sleep, int line) {
        this.sleep = sleep;
        this.line = line;
    }

    public Marker(Long sleep) {
        super();
    }
}
