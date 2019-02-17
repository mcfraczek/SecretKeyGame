package main.java.objects;

import main.java.objects.interfaces.LineObject;

import java.util.List;

public class Panel extends LineObject {
    private List<String> stringList;

    public Panel(List<String> stringList, int line) {
        this.stringList = stringList;
        this.line = line;
    }

    @Override
    public void show() {

    }
}
