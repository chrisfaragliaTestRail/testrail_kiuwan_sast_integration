package com.example.vuln;

import java.io.*;

public class DeserializationService {
    public void deserializeFromBytes(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            // Unsafe deserialization of untrusted bytes
            Object obj = ois.readObject();
            System.out.println("Deserialized object: " + obj);
        } catch (Exception e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        }
    }
}
