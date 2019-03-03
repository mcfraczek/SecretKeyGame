package main.java.configurations;

import com.thoughtworks.xstream.XStream;
import main.java.talePath.TalePath;

import java.io.File;

import static main.java.configurations.InitializeXStream.initializeXStream;

public enum Configuration {
    INSTANCE;
    private final XStream xStream = initializeXStream();
    private final ConfigurationClass configurationClass = getConfigurationClass();
    private final DevConfigurationClass devConfigurationClass = getDevConfigurationClass();

    private ConfigurationClass getConfigurationClass() {
        xStream.processAnnotations(ConfigurationClass.class);
        File configurationFile = TalePath.getTalePath().resolve("configuration.xml").toFile();
        return (ConfigurationClass) xStream.fromXML(configurationFile);
    }

    private DevConfigurationClass getDevConfigurationClass() {
        xStream.processAnnotations(DevConfigurationClass.class);
        File configurationFile = TalePath.getTalePath().resolve("dev_configuration.xml").toFile();
        return (DevConfigurationClass) xStream.fromXML(configurationFile);
    }

    public ConfigurationClass getConfiguration() {
        return configurationClass;
    }

    public DevConfigurationClass getDevConfiguration() {
        return devConfigurationClass;
    }


}
