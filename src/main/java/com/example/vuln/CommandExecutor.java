package com.example.vuln;

public class CommandExecutor {
    public void runCommand(String cmd) {
        try {
            // Using Runtime.exec with concatenated input (command injection risk)
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            System.out.println("Ran command: " + cmd);
        } catch (Exception e) {
            System.out.println("Command failed: " + e.getMessage());
        }
    }
}
