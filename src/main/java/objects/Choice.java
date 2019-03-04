package main.java.objects;

import main.java.objects.interfaces.MarginAvalible;

public class Choice extends MarginAvalible {
    private String text;

    public Choice(String text, int line) {
        this.text = text;
        this.line = line;
        marginSize = configuration.getChoiceMarginSize();
    }

    @Override
    public void show() {
        System.out.println(makeMargin(marginSize) + text);
    }

    @Override
    public String toString() {
        return "Choice{" +
                "text='" + text + '\'' +
                "} ";
    }
}
