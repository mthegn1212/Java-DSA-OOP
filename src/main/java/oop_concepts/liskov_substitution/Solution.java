package oop_concepts.liskov_substitution;

public class Solution {

    // --- 1. BASE CAPABILITY ---
    // All birds can eat, regardless of flight ability.
    static class Bird {
        public void eat() {
            System.out.println("-> This bird is eating.");
        }
    }

    // --- 2. SPECIALIZED CAPABILITY ---
    // Only some birds can fly. We isolate this behavior.
    static class FlyingBird extends Bird {
        public void fly() {
            System.out.println("-> This bird is flying high!");
        }
    }

    // --- 3. CONCRETE IMPLEMENTATIONS ---
    
    // Sparrow is a FlyingBird. It can replace FlyingBird anywhere.
    static class Sparrow extends FlyingBird {
        // Inherits eat() and fly()
    }

    // Ostrich is just a Bird. It CANNOT replace FlyingBird, and that's safe.
    // It maintains LSP because it behaves correctly as a generic Bird.
    static class Ostrich extends Bird {
        @Override
        public void eat() {
            System.out.println("-> Ostrich is eating huge seeds.");
        }
        // No fly() method here, so no risk of runtime errors!
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        System.out.println("--- LSP DEMO ---");

        // 1. Test Flying Bird
        Sparrow sparrow = new Sparrow();
        sparrow.eat();
        sparrow.fly();

        // 2. Test Non-Flying Bird
        Ostrich ostrich = new Ostrich();
        ostrich.eat();
        // ostrich.fly(); // Compile Error! Safe design.

        // 3. Polymorphism Check (Liskov Test)
        // If we treat them as generic Birds, they both work perfectly.
        Bird bird1 = new Sparrow();
        Bird bird2 = new Ostrich();

        System.out.println("\n[Generic Test]");
        bird1.eat();
        bird2.eat();

        // Manual Check
        System.out.println("\n[PASS] No runtime errors. Logic is safe!");
    }
}