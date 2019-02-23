package test;

import main.java.logic.services.objectServices.ShowingUserService;
import main.java.logic.services.objectServices.alreringLine.AlteringLineService;

public class Main2 {
    public static void main(String[] args) {
        String line = "baksnjkas[user]nasj";
        AlteringLineService alteringLineService = new ShowingUserService();
        alteringLineService.alterLine(line);
        System.out.println(line);
    }
}
