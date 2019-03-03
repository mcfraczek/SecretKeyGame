package main.java.configurations.devConfiguration;

import com.thoughtworks.xstream.XStream;
import main.java.talePath.TalePath;

import java.io.File;

import static main.java.configurations.InitializeXStream.initializeXStream;

public enum DevConfiguration {
    INSTANCE;

    private DevConfigurationClass devConfigurationClass;

    DevConfiguration() {
        this.devConfigurationClass = getConfiguration();
    }

    private DevConfigurationClass getConfiguration() {
        XStream xStream = initializeXStream();
        xStream.processAnnotations(DevConfigurationClass.class);
        File configurationFile = TalePath.getTalePath().resolve("dev_configuration.xml").toFile();
        return (DevConfigurationClass) xStream.fromXML(configurationFile);
    }

    public DevConfigurationClass getDevConfigurationClass() {
        return devConfigurationClass;
    }
}
