package main.java.objects.interfaces;


import main.java.configurations.Configuration;
import main.java.configurations.ConfigurationClass;
import main.java.configurations.DevConfigurationClass;

public abstract class LineObject implements ShowingObjectInterface {
    protected DevConfigurationClass devConfiguration = Configuration.INSTANCE.getDevConfiguration();
    protected ConfigurationClass configuration = Configuration.INSTANCE.getConfiguration();
    protected int line;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
