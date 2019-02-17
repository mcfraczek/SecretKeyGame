package main.java.objects;

import main.java.objects.interfaces.LineObject;
import main.java.objects.interfaces.SettingFirstWord;

public class Word extends LineObject implements SettingFirstWord {
    private String word;
    private boolean lastWordInLine;

    public Word(String word, int line) {
        this.word = word;
        this.line = line;
    }

    @Override
    public void thisIsLastWord() {
        this.lastWordInLine = true;
    }

    @Override
    public boolean getFirstWord() {
        return lastWordInLine;
    }

    @Override
    public void show() {
        System.out.print(word);
        if (lastWordInLine) {
            System.out.print("\n");
        }
    }

}
