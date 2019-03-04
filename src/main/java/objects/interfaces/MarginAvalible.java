package main.java.objects.interfaces;

public abstract class MarginAvalible extends LineObject implements MarginMaker {
    protected int marginSize;

    public int getMarginSize() {
        return marginSize;
    }

    public void setMarginSize(int marginSize) {
        this.marginSize = marginSize;
    }
}
