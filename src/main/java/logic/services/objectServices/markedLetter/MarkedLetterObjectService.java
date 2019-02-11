package main.java.logic.services.objectServices.markedLetter;

import main.java.logic.services.objectServices.MarkedObjectService;

public interface MarkedLetterObjectService extends MarkedObjectService {
    void changeMarkedIntoObject(String line, int iteratorStart);
}
