package oop_concepts.factory_pattern;

public class Solution {

    // --- 1. PRODUCT INTERFACE ---
    // Common interface for all notification types
    interface Notification {
        void notifyUser();
    }

    // --- 2. CONCRETE PRODUCTS ---
    // Implementation for Email
    static class EmailNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("-> Sending an EMAIL notification...");
        }
    }

    // Implementation for SMS
    static class SMSNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("-> Sending an SMS notification...");
        }
    }

    // Implementation for Push Notification
    static class PushNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("-> Sending a PUSH notification to mobile app...");
        }
    }

    // --- 3. THE FACTORY ---
    // Responsiblity: Create objects based on given information
    static class NotificationFactory {
        
        // Factory Method
        public Notification createNotification(String channel) {
            if (channel == null || channel.isEmpty()) {
                return null;
            }

            // Centralized object creation logic
            switch (channel.toUpperCase()) {
                case "EMAIL":
                    return new EmailNotification();
                case "SMS":
                    return new SMSNotification();
                case "PUSH":
                    return new PushNotification();
                default:
                    throw new IllegalArgumentException("Unknown channel: " + channel);
            }
        }
    }

    // --- MAIN PROGRAM (CLIENT) ---
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        System.out.println("--- FACTORY PATTERN DEMO ---");

        // 1. Client asks Factory for an Email object
        // Client doesn't need to know 'new EmailNotification()' logic
        Notification msg1 = factory.createNotification("EMAIL");
        msg1.notifyUser();

        // 2. Client asks for SMS
        Notification msg2 = factory.createNotification("SMS");
        msg2.notifyUser();

        // 3. Client asks for Push
        Notification msg3 = factory.createNotification("PUSH");
        msg3.notifyUser();

        // Manual Check
        if (msg1 instanceof EmailNotification && msg2 instanceof SMSNotification) {
            System.out.println("\n[PASS] Factory created correct objects!");
        } else {
            System.out.println("\n[FAIL] Factory logic error.");
        }
    }
}