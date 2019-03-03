package main.java.objects.user;

public class User {
    private static User INSTANCE = null;
    private String name;

    private User(String name) {
        this.name = name;
    }

    public static User setInstance(String name) {
        if (INSTANCE == null) {
            synchronized (User.class) {
                if (INSTANCE == null) {
                    INSTANCE = new User(setFirstLetter(name));
                }
            }
        }
        return INSTANCE;
    }

    public static User getINSTANCE() {
        return INSTANCE;
    }

    private static String setFirstLetter(String name) {
        return name.replace(name.charAt(0), Character.toUpperCase(name.charAt(0)));
    }

    public String getName() {
        return name;
    }
}
