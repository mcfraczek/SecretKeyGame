package main.java.logic.services.objectServices.alreringLine;

import main.java.objects.user.User;

import java.util.Scanner;

public class IntroducingUser {
    public static void introduceUser(Scanner scanner) {
        System.out.println("Type Your name: ");
        String name = scanner.nextLine();
        User.getInstance(name);
    }
}
