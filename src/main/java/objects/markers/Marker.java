package main.java.objects.markers;


import main.java.objects.LineObject;

public abstract class Marker extends LineObject {
    protected Long sleep;

    public Marker( Long sleep, int line) {
        this.sleep = sleep;
        this.line = line;
    }

    public Marker(Long sleep) {
        super();
    }
}
