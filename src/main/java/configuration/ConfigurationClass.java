package main.java.configuration;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class ConfigurationClass {
    @XStreamAlias("unable_threed_sleep")
    private final boolean unableThreedSleep;
    @XStreamAlias("disable_simple_questions")
    private final boolean disableSimpleQuestions;
    @XStreamAlias("start_from_this_file")
    private final String startFromThisFile;

    public ConfigurationClass(boolean unableThreedSleep, boolean disableSimpleQuestions, String startFromThisFile) {
        this.unableThreedSleep = unableThreedSleep;
        this.disableSimpleQuestions = disableSimpleQuestions;
        this.startFromThisFile = startFromThisFile;
    }

    public boolean isUnableThreedSleep() {
        return unableThreedSleep;
    }

    public boolean isDisableSimpleQuestions() {
        return disableSimpleQuestions;
    }

    public String getStartFromThisFile() {
        return startFromThisFile;
    }
}
