package oop_concepts.single_responsibility;

public class Solution {

    // --- 1. RESPONSIBILITY: HOLDING DATA ---
    // This class ONLY holds data. It knows nothing about DB or Email.
    static class User {
        private String name;
        private String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
    }

    // --- 2. RESPONSIBILITY: DATABASE OPERATIONS ---
    // This class ONLY handles database logic.
    static class UserRepository {
        public void save(User user) {
            System.out.println("-> [DB] Saving user " + user.getName() + " to Database...");
            // Real DB code goes here (INSERT INTO users...)
        }
    }

    // --- 3. RESPONSIBILITY: NOTIFICATION ---
    // This class ONLY handles email logic.
    static class EmailService {
        public void sendWelcomeEmail(User user) {
            System.out.println("-> [EMAIL] Sending welcome email to " + user.getEmail() + "...");
            // Real Email code goes here (SMTP, API...)
        }
    }

    // --- MAIN PROGRAM (CONTROLLER) ---
    // The main class orchestrates the workflow using the specialized classes.
    public static void main(String[] args) {
        System.out.println("--- SRP DEMO ---");

        // 1. Create Data
        User newUser = new User("Dylan", "dylan@example.com");

        // 2. Use Repository to save
        UserRepository repo = new UserRepository();
        repo.save(newUser);

        // 3. Use Service to send email
        EmailService mailer = new EmailService();
        mailer.sendWelcomeEmail(newUser);

        // Manual Check
        System.out.println("\n[PASS] Responsibilities are separated correctly!");
    }
}