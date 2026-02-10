package oop_concepts.four_pillars;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // --- 1. ABSTRACTION ---
    // Abstract parent class, defining the common structure
    static abstract class Employee {
        // --- 2. ENCAPSULATION ---
        // Private attributes to protect data
        private String name;
        private int id;

        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        // Getters/Setters for safe data access
        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        // Abstract method: Children must implement their own logic
        public abstract double calculateSalary();

        // Concrete method: Shared by all children
        public void displayInfo() {
            System.out.println("ID: " + id + " | Name: " + name + " | Salary: $" + calculateSalary());
        }
    }

    // --- 3. INHERITANCE ---
    // Full-time employee inherits from Employee
    static class FullTimeEmployee extends Employee {
        private double monthlySalary;

        public FullTimeEmployee(String name, int id, double monthlySalary) {
            super(name, id); // Call parent constructor
            this.monthlySalary = monthlySalary;
        }

        // --- 4. POLYMORPHISM ---
        // Override specific salary calculation
        @Override
        public double calculateSalary() {
            return monthlySalary;
        }
    }

    // Part-time employee inherits from Employee
    static class PartTimeEmployee extends Employee {
        private double hourlyRate;
        private int hoursWorked;

        public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
            super(name, id);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        // --- 4. POLYMORPHISM ---
        // Override salary calculation (different from Full-time)
        @Override
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        // Create a list containing various employee types (Polymorphism)
        List<Employee> employeeList = new ArrayList<>();

        // Add Full-time employees
        employeeList.add(new FullTimeEmployee("John Doe", 101, 3000));
        employeeList.add(new FullTimeEmployee("Jane Smith", 102, 4500));

        // Add Part-time employees
        employeeList.add(new PartTimeEmployee("Bob Brown", 103, 20, 100)); // $20/h * 100h
        employeeList.add(new PartTimeEmployee("Alice White", 104, 25, 50));  // $25/h * 50h

        System.out.println("--- EMPLOYEE PAYROLL ---");
        
        // Iterate through list and call displayInfo()
        // JVM automatically determines which calculateSalary() to call (Runtime Polymorphism)
        for (Employee emp : employeeList) {
            emp.displayInfo();
        }

        // Manual Check
        double salaryBob = employeeList.get(2).calculateSalary(); // 20 * 100 = 2000
        if (salaryBob == 2000.0) {
            System.out.println("\n[PASS] OOP Logic works correctly!");
        } else {
            System.out.println("\n[FAIL] Salary calculation is incorrect!");
        }
    }
}