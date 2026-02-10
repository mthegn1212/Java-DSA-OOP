package oop_concepts.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // --- 1. DEFINING THE INTERFACE ---
    // The "Contract". Any class implementing this MUST provide these methods.
    interface Shape {
        double getArea();
        double getPerimeter();
    }

    // --- 2. IMPLEMENTATION ---
    // Circle "signs the contract" to be a Shape
    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    // Rectangle "signs the contract" to be a Shape
    static class Rectangle implements Shape {
        private double width;
        private double length;

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        @Override
        public double getArea() {
            return width * length;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + length);
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        // Polymorphism via Interface: List of 'Shape' objects
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(4.0, 6.0));

        System.out.println("--- SHAPE CALCULATOR ---");

        for (Shape s : shapes) {
            // Check type specifically to print friendly names (Optional)
            String shapeType = (s instanceof Circle) ? "Circle" : "Rectangle";
            
            System.out.printf("Type: %s | Area: %.2f | Perimeter: %.2f%n", 
                              shapeType, s.getArea(), s.getPerimeter());
        }

        // Manual Check
        // Rectangle Area: 4 * 6 = 24.0
        if (shapes.get(1).getArea() == 24.0) {
            System.out.println("\n[PASS] Interface implementation works correctly!");
        } else {
            System.out.println("\n[FAIL] Calculation error!");
        }
    }
}