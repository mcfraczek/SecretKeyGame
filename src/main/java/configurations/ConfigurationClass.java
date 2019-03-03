package main.java.configurations;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class ConfigurationClass {
    @XStreamAlias("speed")
    private final double speed;

    public ConfigurationClass(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }
}
