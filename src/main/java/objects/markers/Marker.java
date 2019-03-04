package main.java.objects.markers;


import main.java.configurations.Configuration;
import main.java.objects.interfaces.MarginAvalible;

public abstract class Marker extends MarginAvalible {

    protected Long sleep;
    protected boolean threadSleepAnabled = !Configuration.INSTANCE.getDevConfiguration().isDisableThreadSleep();

    public Marker(Long sleep, int line) {
        this.line = line;
        double speed = configuration.getSpeed();
        if (speed <= 0) {
            speed = 0.1;
        }
        this.sleep = (long) (sleep / speed);
    }
}
