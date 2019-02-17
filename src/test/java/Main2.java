package test.java;

import main.java.logic.services.objectServices.markedLetter.WordSleepSercice;
import main.java.objects.interfaces.ShowingObjectInterface;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<ShowingObjectInterface> objectsList = new ArrayList<>();
        String line = "#sadafds#<t=144>fafsasd<>#fdsdfdsfdsd#<t=23>dsds<>#sdfsd#adsada";
        WordSleepSercice wordSleepSercice = new WordSleepSercice();
        List<ShowingObjectInterface> objects = wordSleepSercice.changeMarkedIntoObject(line, 1);
        System.out.println(objects);
    }
}
