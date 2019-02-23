package main.java.logic.services.objectServices.alreringLine;

import main.java.logic.services.objectServices.patternFactory.PatternFactory;
import main.java.objects.user.User;

import java.util.Scanner;

import static main.java.logic.services.objectServices.markedInterfaces.GeneralMarkService.findThisPattern;

public class IntroducingUser {

    public static void introduceUser(Scanner scanner) {
        System.out.println("Type Your name:");
        String name = scanner.nextLine();
        if (findThisPattern(name, PatternFactory.WORD_SLEEP.getGeneral()) || findThisPattern(name, PatternFactory.LINE_SLEEP.getGeneral())) {
            while (findThisPattern(name, PatternFactory.WORD_SLEEP.getGeneral()) ||
                    findThisPattern(name, PatternFactory.LINE_SLEEP.getGeneral())) {
                System.out.println("Please - don't cheat");
                name = scanner.nextLine();
            }
        }
        User.setInstance(name);
    }
}
