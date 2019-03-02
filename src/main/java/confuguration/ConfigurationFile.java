package main.java.confuguration;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class ConfigurationFile {
    @XStreamAlias("unable_threed_sleep")
    private final boolean unableThreedSleep;

    public ConfigurationFile(boolean unableThreedSleep) {
        this.unableThreedSleep = unableThreedSleep;
    }

    public boolean isUnableThreedSleep() {
        return unableThreedSleep;
    }
}
