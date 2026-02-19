package oop_concepts.dependency_inversion;

public class Solution {

    // --- 1. THE ABSTRACTION ---
    // High-level modules and Low-level modules will both depend on this.
    interface PaymentProcessor {
        void pay(double amount);
    }

    // --- 2. LOW-LEVEL MODULES (Details) ---
    // These implement the abstraction.
    static class MomoPayment implements PaymentProcessor {
        @Override
        public void pay(double amount) {
            System.out.println("-> [Momo] Processing payment of $" + amount + " via Momo E-Wallet.");
        }
    }

    static class ZaloPayPayment implements PaymentProcessor {
        @Override
        public void pay(double amount) {
            System.out.println("-> [ZaloPay] Processing payment of $" + amount + " via ZaloPay QR Code.");
        }
    }

    // --- 3. HIGH-LEVEL MODULE (Business Logic) ---
    // ECommerceCheckout DOES NOT depend on Momo or ZaloPay directly.
    // It only depends on the PaymentProcessor interface.
    static class ECommerceCheckout {
        private PaymentProcessor paymentProcessor;

        // Dependency Injection: The specific payment method is "injected" from outside.
        // We don't use 'new MomoPayment()' inside here!
        public ECommerceCheckout(PaymentProcessor paymentProcessor) {
            this.paymentProcessor = paymentProcessor;
        }

        public void processOrder(String orderId, double totalAmount) {
            System.out.println("\nOrder " + orderId + " is ready for checkout.");
            // Delegation to the abstraction
            paymentProcessor.pay(totalAmount);
            System.out.println("Order " + orderId + " completed successfully!");
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        System.out.println("--- DIP DEMO: E-COMMERCE PAYMENT ---");

        // 1. Customer chooses Momo
        PaymentProcessor momo = new MomoPayment();
        ECommerceCheckout checkout1 = new ECommerceCheckout(momo);
        checkout1.processOrder("ORD-001", 150.50);

        // 2. Customer chooses ZaloPay (Notice we didn't change ECommerceCheckout class at all!)
        PaymentProcessor zalo = new ZaloPayPayment();
        ECommerceCheckout checkout2 = new ECommerceCheckout(zalo);
        checkout2.processOrder("ORD-002", 300.00);

        // Manual Check
        System.out.println("\n[PASS] High-level logic is decoupled from low-level implementations!");
    }
}