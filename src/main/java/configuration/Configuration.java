package main.java.configuration;

import com.thoughtworks.xstream.XStream;
import main.java.talePath.TalePath;

import java.io.File;

public enum Configuration {
    INSTANCE;

    private ConfigurationClass configurationClass;

    Configuration() {
        this.configurationClass = getConfiguration();
    }

    private ConfigurationClass getConfiguration() {
        Class<?>[] classes = new Class[]{ConfigurationClass.class};
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
        xStream.processAnnotations(ConfigurationClass.class);
        File configurationFile = TalePath.getTalePath().resolve("configuration.xml").toFile();
        return (ConfigurationClass) xStream.fromXML(configurationFile);
    }

    public ConfigurationClass getConfigurationClass() {
        return configurationClass;
    }
}
