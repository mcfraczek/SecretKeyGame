package main.java.logic.services.reading;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TextReadingService implements ReadingService {
    @Override
    public List<String> read(Path path) {
        List<String> stringList = null;
        try (InputStream inputStream = Files.newInputStream(path);
             Reader reader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(reader)) {
            stringList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
