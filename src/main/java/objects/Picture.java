package main.java.objects;

public class Picture extends LineObject{
    private String text;

    public Picture(String text, int line) {
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
