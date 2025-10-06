package com.example.vuln;

public class AuthService {
    // Hard-coded credentials - easily flagged by scanners
    private static final String USER = "admin";
    private static final String PASS = "password123";

    public boolean login(String user, String pass) {
        // insecure comparison and hardcoded credential usage
        return USER.equals(user) && PASS.equals(pass);
    }
}
