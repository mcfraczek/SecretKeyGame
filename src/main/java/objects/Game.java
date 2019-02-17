package main.java.objects;

import main.java.objects.interfaces.LineObject;

public class Game extends LineObject {
    private String text;

    public Game(String text, int line) {
        this.text = text;
        this.line = line;
    }

    @Override
    public void show() {
        System.out.println(text);
    }

    @Override
    public String toString() {
        return "Game{" +
                "text='" + text + '\'' +
                "} ";
    }
}
