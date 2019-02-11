package main.java.objects.markers;

public class SleepMarker extends Marker {

    public SleepMarker(Long sleep, int line) {
        super(sleep, line);
    }

    @Override
    public void show() {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "SleepMarker{" +
                "sleep=" + sleep +
                "} ";
    }
}
