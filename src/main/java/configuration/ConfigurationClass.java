package main.java.configuration;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class ConfigurationClass {
    @XStreamAlias("unable_threed_sleep")
    private final boolean unableThreedSleep;
    @XStreamAlias("back_brings_everything")
    private final boolean backBringsEverything;
    @XStreamAlias("start_from_this_file")
    private final String startFromThisFile;

    public ConfigurationClass(boolean unableThreedSleep, boolean backBringsEverything, String startFromThisFile) {
        this.unableThreedSleep = unableThreedSleep;
        this.backBringsEverything = backBringsEverything;
        this.startFromThisFile = startFromThisFile;
    }

    public boolean isUnableThreedSleep() {
        return unableThreedSleep;
    }


    public String getStartFromThisFile() {
        return startFromThisFile;
    }

    public boolean isBackBringsEverything() {
        return backBringsEverything;
    }
}
