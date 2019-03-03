package main.java.configurations.devConfiguration;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class DevConfigurationClass {
    @XStreamAlias("disable_thread_sleep")
    private final boolean disableThreadSleep;
    @XStreamAlias("back_brings_everything")
    private final boolean backBringsEverything;
    @XStreamAlias("start_from_this_file")
    private final String startFromThisFile;

    public DevConfigurationClass(boolean disableThreadSleep, boolean backBringsEverything, String startFromThisFile) {
        this.disableThreadSleep = disableThreadSleep;
        this.backBringsEverything = backBringsEverything;
        this.startFromThisFile = startFromThisFile;
    }

    public boolean isDisableThreadSleep() {
        return disableThreadSleep;
    }


    public String getStartFromThisFile() {
        return startFromThisFile;
    }

    public boolean isBackBringsEverything() {
        return backBringsEverything;
    }
}
