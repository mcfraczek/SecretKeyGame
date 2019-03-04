package main.java.objects.interfaces;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface MarginMaker {
    default String makeMargin(int size) {
        return Stream.generate(() -> " ").limit(size).collect(Collectors.joining());
    }
}
