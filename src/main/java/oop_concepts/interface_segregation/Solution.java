package oop_concepts.interface_segregation;

public class Solution {

    // --- 1. SEGREGATED INTERFACES ---
    // Instead of one big 'Machine' interface, we split them.
    interface Printer {
        void print(String content);
    }

    interface Scanner {
        void scan(String content);
    }

    interface Fax {
        void fax(String content);
    }

    // --- 2. CLIENT IMPLEMENTATIONS ---

    // This Old Printer ONLY needs printing capability.
    // It is NOT forced to implement scan() or fax().
    static class OldFashionedPrinter implements Printer {
        @Override
        public void print(String content) {
            System.out.println("-> [Old Printer] Printing: " + content);
        }
    }

    // This Modern Machine can do everything.
    // It implements multiple interfaces.
    static class MultiFunctionPrinter implements Printer, Scanner, Fax {
        @Override
        public void print(String content) {
            System.out.println("-> [Smart Printer] Printing high quality: " + content);
        }

        @Override
        public void scan(String content) {
            System.out.println("-> [Smart Printer] Scanning to PDF: " + content);
        }

        @Override
        public void fax(String content) {
            System.out.println("-> [Smart Printer] Sending Fax: " + content);
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        System.out.println("--- ISP DEMO ---");

        // 1. Using Old Printer
        // We only see print() method available. Safe and clean.
        Printer oldP = new OldFashionedPrinter();
        oldP.print("Hello World");
        // oldP.scan(...); // Compile Error! Good.

        // 2. Using Smart Printer
        MultiFunctionPrinter smartP = new MultiFunctionPrinter();
        smartP.print("My Resume");
        smartP.scan("My ID Card");
        smartP.fax("Contract");

        // Manual Check
        System.out.println("\n[PASS] Interface Segregation implemented correctly!");
    }
}