package main.java.objects.markers;

import main.java.objects.interfaces.SettingFirstWord;

public class TypewritterEffect extends Marker implements SettingFirstWord {
    private boolean firstWordInLine;

    public TypewritterEffect(Long sleep, int line) {
        super(sleep, line);
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
