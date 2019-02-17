package main.java.objects;

public class Image extends LineObject {
    private String text;

    public Image(String text, int line) {
        this.text = text;
        this.line = line;
    }

    @Override
    public void show() {
        System.out.println(text);
    }

    @Override
    public String toString() {
        return "Image{" +
                "text='" + text + '\'' +
                "} ";
    }
}
