package main.java.objects;

public class Text extends LineObject {
    private String text;

    public Text(String text, int line) {
        this.text = text;
        this.line = line;
    }

    @Override
    public void show() {
        System.out.println(text);
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                "} ";
    }
}
