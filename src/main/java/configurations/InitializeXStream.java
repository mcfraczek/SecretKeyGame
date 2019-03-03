package main.java.configurations;

import com.thoughtworks.xstream.XStream;

public interface InitializeXStream {
    static XStream initializeXStream() {
        Class<?>[] classes = new Class[]{ConfigurationClass.class, DevConfigurationClass.class};
        XStream xStream = new XStream();
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
        return xStream;
    }
}
