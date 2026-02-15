package oop_concepts.open_closed;

public class Solution {

    // --- 1. THE ABSTRACTION (OPEN FOR EXTENSION) ---
    // Interface defines the contract. New shapes just need to sign this contract.
    interface Shape {
        double calculateArea();
    }

    // --- 2. CONCRETE IMPLEMENTATIONS ---
    static class Rectangle implements Shape {
        public double width;
        public double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    static class Circle implements Shape {
        public double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    // --- 3. THE CONSUMER (CLOSED FOR MODIFICATION) ---
    // This class doesn't care what specific shape it is.
    // It works with ANY class that implements Shape.
    // We NEVER need to modify this class when adding new shapes.
    static class AreaCalculator {
        public double calculateTotalArea(Shape[] shapes) {
            double totalArea = 0;
            for (Shape shape : shapes) {
                // Polymorphism in action
                totalArea += shape.calculateArea();
            }
            return totalArea;
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        System.out.println("--- OCP DEMO ---");

        // 1. Create shapes
        Rectangle r1 = new Rectangle(5, 10); // 50
        Circle c1 = new Circle(10);          // 314.159...

        // 2. Put them in a list
        Shape[] myShapes = {r1, c1};

        // 3. Calculate total
        AreaCalculator calculator = new AreaCalculator();
        double total = calculator.calculateTotalArea(myShapes);

        System.out.printf("Total Area: %.2f%n", total);

        // Manual Check
        if (total > 364.0 && total < 365.0) {
            System.out.println("[PASS] OCP Logic works correctly!");
        }
    }
}