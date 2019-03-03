package main.java.configurations;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class ConfigurationClass {
    @XStreamAlias("speed")
    private final double speed;
    @XStreamAlias("save_path")
    private String savePath;

    public ConfigurationClass(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
