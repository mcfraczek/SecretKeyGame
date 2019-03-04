package main.java.objects;

import main.java.objects.interfaces.MarginAvalible;

public class Game extends MarginAvalible {
    private String text;

    public Game(String text, int line) {
        this.text = text;
        this.line = line;
        marginSize = configuration.getGameMarginSize();
    }

    @Override
    public void show() {
        System.out.println(makeMargin(marginSize) + text);
    }

    @Override
    public String toString() {
        return "Game{" +
                "text='" + text + '\'' +
                "} ";
    }
}
