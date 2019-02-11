package main.java.logic.services.objectServices;


import main.java.objects.interfaces.ShowingObjectInterface;

public interface MarkedObjectService {
    boolean thereIsAMark(String line);

    ShowingObjectInterface changeMarkedIntoObject(String line, int lineNumber);

}
