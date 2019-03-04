package main.java.objects;

import main.java.objects.interfaces.MarginAvalible;
import main.java.objects.interfaces.SettingFirstOrLastWord;

public class Word extends MarginAvalible implements SettingFirstOrLastWord {
    private String word;
    private boolean lastWordInLine;
    private boolean firstWordInLine;

    public Word(String word, int line) {
        this.word = word;
        this.line = line;
        marginSize = configuration.getGameMarginSize();
    }

    @Override
    public void thisIsLastWord() {
        this.lastWordInLine = true;
    }

    @Override
    public void thisIsFirstWord() {
        this.firstWordInLine = true;
    }

    @Override
    public boolean getFirstWord() {
        return lastWordInLine;
    }

    @Override
    public void show() {
        if (firstWordInLine) {
            System.out.print(makeMargin(marginSize));
        }
        System.out.print(word);
        if (lastWordInLine) {
            System.out.print("\n");
        }
    }
}
