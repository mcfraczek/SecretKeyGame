package main.java.confuguration;

import com.thoughtworks.xstream.XStream;
import main.java.talePath.TalePath;

import java.io.File;

public enum Configuration {
    INSTANCE;

    private ConfigurationFile configurationFile;

    Configuration() {
        this.configurationFile = getConfiguration();
    }

    private ConfigurationFile getConfiguration() {
        XStream xStream = new XStream();
        xStream.processAnnotations(ConfigurationFile.class);
        File configurationFile = TalePath.getTalePath().resolve("configuration.xml").toFile();
        return (ConfigurationFile) xStream.fromXML(configurationFile);
    }

    public ConfigurationFile getConfigurationFile() {
        return configurationFile;
    }
}
