package main.java.objects.user;

public class User {
    private static User INSTANCE = null;
    private String name;

    private User(String name) {
        this.name = name;
    }

    public static User getInstance(String name) {
        if (INSTANCE == null) {
            synchronized (User.class) {
                if (INSTANCE == null) {
                    INSTANCE = new User(name);
                }
            }
        }
        return INSTANCE;
    }

    public static User getINSTANCE() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }
}
