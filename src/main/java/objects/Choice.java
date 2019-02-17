package main.java.objects;

public class Choice extends LineObject {
    private String text;

    public Choice(String text, int line) {
        this.text = text;
        this.line = line;
    }

    @Override
    public void show() {
        System.out.println(text);
    }

    @Override
    public String toString() {
        return "Choice{" +
                "text='" + text + '\'' +
                "} ";
    }
}
