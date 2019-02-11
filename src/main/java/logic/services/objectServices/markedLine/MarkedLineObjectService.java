package main.java.logic.services.objectServices.markedLine;


import main.java.logic.services.objectServices.MarkedObjectService;
import main.java.objects.interfaces.ShowingObjectInterface;

public interface MarkedLineObjectService extends MarkedObjectService {
    ShowingObjectInterface changeMarkedIntoObject(String line, int lineNumber);
}
