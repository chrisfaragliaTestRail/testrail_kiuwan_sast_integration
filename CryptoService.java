package com.example.vuln;

import java.security.MessageDigest;

public class CryptoService {
    public String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // weak hash
            byte[] d = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : d) sb.append(String.format("%02x", b & 0xff));
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
