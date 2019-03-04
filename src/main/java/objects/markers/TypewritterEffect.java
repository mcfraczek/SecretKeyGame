package main.java.objects.markers;

import main.java.objects.interfaces.SettingFirstOrLastWord;

public class TypewritterEffect extends Marker implements SettingFirstOrLastWord {
    private boolean lastWordInLine;
    private boolean firstWordInLine;
    private String word;

    public TypewritterEffect(Long sleep, String word, int line) {
        super(sleep, line);
        this.word = word;
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
        if (word.isEmpty()) {
            if (threadSleepAnabled) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (firstWordInLine) {
                System.out.print(makeMargin(marginSize));
            }
            word.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .forEach(w -> {
                        if (threadSleepAnabled) {
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
