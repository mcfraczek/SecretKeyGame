package main.java.logic.services.objectServices.markedLetter;

import main.java.logic.services.objectServices.MarkedObjectService;
import main.java.objects.interfaces.ShowingObjectInterface;

import java.util.List;

public interface MarkedLetterService extends MarkedObjectService {
    List<ShowingObjectInterface> changeMarkedIntoObject(String line, int iteratorStart);
}
