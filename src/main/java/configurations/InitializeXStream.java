package main.java.configurations;

import com.thoughtworks.xstream.XStream;
import main.java.configurations.devConfiguration.DevConfigurationClass;

public interface InitializeXStream {
    static XStream initializeXStream() {
        Class<?>[] classes = new Class[]{DevConfigurationClass.class};
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
        return xStream;
    }
}
