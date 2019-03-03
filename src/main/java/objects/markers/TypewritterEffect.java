package main.java.objects.markers;

import main.java.objects.interfaces.SettingFirstWord;

public class TypewritterEffect extends Marker implements SettingFirstWord {
    private boolean lastWordInLine;
    private String word;

    public TypewritterEffect(Long sleep, String word, int line) {
        super(sleep, line);
        this.word = word;
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
        if (word.isEmpty()) {
            if (!configuration.isDisableThreadSleep()) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } else {
            word.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .forEach(w -> {
                        if (!configuration.isDisableThreadSleep()) {
                            try {
                                Thread.sleep(sleep);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(w);
                    });
            if (lastWordInLine) {
                System.out.print("\n");
            }
        }
    }
}
