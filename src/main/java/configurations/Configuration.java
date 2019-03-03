package main.java.configurations;

import com.thoughtworks.xstream.XStream;
import main.java.talePath.TalePath;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static main.java.configurations.InitializeXStream.initializeXStream;

public enum Configuration {
    INSTANCE;
    private final XStream xStream = initializeXStream();
    private final Path configurationPath = TalePath.getTalePath().getParent().resolve("configurations");
    private final DevConfigurationClass devConfigurationClass = getDevConfigurationClass();
    private final ConfigurationClass configurationClass = getConfigurationClass();

    private ConfigurationClass getConfigurationClass() {
        xStream.processAnnotations(ConfigurationClass.class);
        File configurationFile = configurationPath.resolve("configuration.xml").toFile();
        return (ConfigurationClass) xStream.fromXML(configurationFile);
    }

    private DevConfigurationClass getDevConfigurationClass() {
        xStream.processAnnotations(DevConfigurationClass.class);
        File configurationFile = configurationPath.resolve("dev_configuration.xml").toFile();
        return (DevConfigurationClass) xStream.fromXML(configurationFile);
    }

    public ConfigurationClass getConfiguration() {
        return configurationClass;
    }

    public DevConfigurationClass getDevConfiguration() {
        return devConfigurationClass;
    }


    public void saveConfiguration() {
        OutputStream outputStream = null;
        try {
            outputStream = Files.newOutputStream(configurationPath.resolve("configuration.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        xStream.toXML(configurationClass, outputStream);
    }
}
