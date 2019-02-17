package main.java.objects;

import main.java.objects.interfaces.LineObject;
import main.java.objects.interfaces.SettingFirstWord;

public class Word extends LineObject implements SettingFirstWord {
    private String word;
    private boolean firstWordInLine;

    public Word(String word, int line) {
        this.word = word;
        this.line = line;
    }

    @Override
    public void thisIsFirstWord() {
        this.firstWordInLine = true;
    }

    @Override
    public boolean getFirstWord() {
        return firstWordInLine;
    }

    @Override
    public void show() {

    }

}
