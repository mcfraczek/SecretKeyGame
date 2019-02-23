package test;

import main.java.logic.services.objectServices.alreringLine.IntroducingUser;
import main.java.logic.services.objectServices.patternFactory.PatternFactory;
import main.java.objects.user.User;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        IntroducingUser.introduceUser(new Scanner(System.in));
        User user = User.getINSTANCE();
        System.out.println(user.getName());
        System.out.println(PatternFactory.WORD_SLEEP.getDetails().toString());
    }
}
