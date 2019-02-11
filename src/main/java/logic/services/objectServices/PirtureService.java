package main.java.logic.services.objectServices;


import main.java.objects.interfaces.ShowingObjectInterface;

public class PirtureService implements MarkedObjectService {
    @Override
    public boolean thereIsAMark(String line) {
        return false;
    }

    @Override
    public ShowingObjectInterface changeMarkedIntoObject(String line, int lineNumber) {
        return null;
    }
}
