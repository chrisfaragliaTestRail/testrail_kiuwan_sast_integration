package com.example.vuln;

public class DatabaseService {
    public void query(String sql) {
        // Simulates executing an SQL string built via concatenation (SQL injection risk)
        System.out.println("Executing SQL: " + sql);
        // (Not actually connecting to a DB) -- static analyzers will flag the pattern
    }
}
