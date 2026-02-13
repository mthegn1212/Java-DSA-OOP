package oop_concepts.generics;

public class Solution {

    // --- GENERIC CLASS ---
    // <T> stands for "Type". It's a placeholder.
    // When we use this class, we will specify what T actually is (Integer, String, etc.)
    static class Box<T> {
        private T content;

        public void set(T content) {
            this.content = content;
        }

        public T get() {
            return content;
        }

        public void printContent() {
            System.out.println("Box contains: " + content + " (Type: " + content.getClass().getSimpleName() + ")");
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        System.out.println("--- GENERICS DEMO ---");

        // 1. Create a Box for Integer
        // T becomes Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        // intBox.set("Hello"); // Compile Error! (Safety check)
        System.out.print("Integer Box: ");
        intBox.printContent();

        // 2. Create a Box for String
        // T becomes String
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics");
        System.out.print("String Box:  ");
        strBox.printContent();

        // 3. Create a Box for Double
        // T becomes Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(99.99);
        System.out.print("Double Box:  ");
        doubleBox.printContent();
        
        // 4. Retrieving data WITHOUT casting
        // Old way (Object): Integer val = (Integer) box.get();
        // New way (Generics):
        Integer value = intBox.get(); // No casting needed!
        System.out.println("\n[PASS] Successfully retrieved value: " + value);
    }
}