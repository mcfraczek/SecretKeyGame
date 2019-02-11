package main.java.objects;


import main.java.objects.interfaces.ShowingObjectInterface;

public abstract class LineObject implements ShowingObjectInterface {
    protected int line;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
}
