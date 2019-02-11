package main.java.logic.services.reading;


import java.nio.file.Path;
import java.util.List;

public interface ReadingService {
    List<String> read(Path path);
}
