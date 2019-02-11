package main.java.objects;

import java.util.List;

public class Picture extends LineObject{
    private List<String> stringList;

    public Picture(List<String> stringList, int line) {
        this.stringList = stringList;
        this.line = line;
    }

    @Override
    public void show() {

    }
}
