package oop_concepts.singleton;

public class Solution {

    // --- SINGLETON CLASS ---
    static class DatabaseConnection {
        
        // 1. Private static variable to hold the single instance
        // "static" means it belongs to the class, not instances.
        private static DatabaseConnection instance;

        // 2. Private constructor to prevent instantiation from outside
        private DatabaseConnection() {
            System.out.println("-> Simulating connecting to Database... (Expensive Operation)");
        }

        // 3. Public static method to provide global access
        // Lazy Initialization: Create instance ONLY when needed
        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        // Example business method
        public void executeQuery(String query) {
            System.out.println("Executing SQL: " + query);
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        System.out.println("--- SINGLETON TEST ---");

        // Try to get the instance for the first time
        System.out.println("1. Requesting connection #1...");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.executeQuery("SELECT * FROM users");

        // Try to get the instance again
        System.out.println("\n2. Requesting connection #2...");
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.executeQuery("UPDATE users SET name='Alice'");

        // --- VERIFICATION ---
        // Check if db1 and db2 point to the SAME memory address
        if (db1 == db2) {
            System.out.println("\n[PASS] Both variables point to the SAME instance!");
            System.out.println("Memory Address: " + db1);
        } else {
            System.out.println("\n[FAIL] Singleton failed, different instances created.");
        }
    }
}