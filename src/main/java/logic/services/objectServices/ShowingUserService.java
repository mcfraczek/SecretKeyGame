package main.java.logic.services.objectServices;

import main.java.logic.services.objectServices.alreringLine.AlteringLineService;
import main.java.logic.services.objectServices.markedInterfaces.GeneralMarkService;
import main.java.objects.user.User;

import java.util.regex.Pattern;

public class ShowingUserService implements AlteringLineService {
    @Override
    public String alterLine(String line) {
        User user = User.getINSTANCE();
        return line.replaceAll("\\[user]", user.getName());
    }

    @Override
    public boolean thereIsAMark(String line) {
        Pattern pattern = Pattern.compile("\\[user]");
        return GeneralMarkService.findThisPattern(line, pattern);
    }
}
