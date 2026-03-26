package org.example.security;

public class Security {
    private static final String PASSWORD = "1112";

    public static boolean checkPassword(String password) {
        return password.equals(PASSWORD);
    }
}
