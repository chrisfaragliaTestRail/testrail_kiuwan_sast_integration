package com.example.vuln;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Vulnerable sample app. Enter command (or 'exit'):");

        while (true) {
            System.out.print("> ");
            String input = s.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;

            // hardcoded credentials usage
            AuthService auth = new AuthService();
            if (!auth.login("admin", "password123")) {
                System.out.println("Auth failed (but credentials hardcoded)");
            }

            // SQL usage with concatenation
            DatabaseService db = new DatabaseService();
            String userQuery = "SELECT * FROM users WHERE name='" + input + "'";
            db.query(userQuery);

            // insecure crypto
            CryptoService crypto = new CryptoService();
            System.out.println("MD5 of input: " + crypto.md5(input));

            // XML parse (XXE)
            XmlParser xp = new XmlParser();
            xp.parse("<?xml version=\"1.0\"?>\n<!DOCTYPE foo [ <!ELEMENT foo ANY > <!ENTITY xxe SYSTEM \"file:///etc/hosts\" >]><foo>&xxe;</foo>");

            // unsafe deserialization (reading bytes from input string for demo only)
            DeserializationService ds = new DeserializationService();
            ds.deserializeFromBytes(input.getBytes());

            // runtime exec with untrusted input
            CommandExecutor ce = new CommandExecutor();
            ce.runCommand("echo " + input);

            System.out.println();
        }

        s.close();
    }
}
