package oop_concepts.composition;

public class Solution {

    // --- COMPONENT 1: PROCESSOR ---
    static class Processor {
        private String model;
        private String manufacturer;

        public Processor(String model, String manufacturer) {
            this.model = model;
            this.manufacturer = manufacturer;
        }

        public void process() {
            System.out.println("-> CPU " + manufacturer + " " + model + " is processing data...");
        }
    }

    // --- COMPONENT 2: MEMORY (RAM) ---
    static class Memory {
        private int sizeGB;
        private String type;

        public Memory(int sizeGB, String type) {
            this.sizeGB = sizeGB;
            this.type = type;
        }

        public void load() {
            System.out.println("-> Memory (" + sizeGB + "GB " + type + ") is loading applications...");
        }
    }

    // --- COMPONENT 3: MONITOR ---
    static class Monitor {
        private String resolution;

        public Monitor(String resolution) {
            this.resolution = resolution;
        }

        public void drawPixel(int x, int y, String color) {
            System.out.println("-> Monitor (" + resolution + ") drawing pixel at [" + x + "," + y + "] with color " + color);
        }
    }

    // --- THE COMPOSITE OBJECT: COMPUTER ---
    // A Computer "HAS A" Processor, "HAS A" Memory, "HAS A" Monitor.
    static class Computer {
        private Processor cpu;
        private Memory ram;
        private Monitor monitor;

        // Constructor: Assembling the computer (Dependency Injection)
        public Computer(Processor cpu, Memory ram, Monitor monitor) {
            this.cpu = cpu;
            this.ram = ram;
            this.monitor = monitor;
        }

        public void powerOn() {
            System.out.println("=== Powering On System ===");
            // Delegation: The computer delegates tasks to its components
            ram.load();
            cpu.process();
            monitor.drawPixel(100, 100, "Blue");
            System.out.println("=== System Ready ===");
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        // 1. Create individual components
        Processor myCpu = new Processor("Core i9", "Intel");
        Memory myRam = new Memory(32, "DDR5");
        Monitor myMonitor = new Monitor("4K UHD");

        // 2. Assemble the computer (Composition)
        Computer gamingPC = new Computer(myCpu, myRam, myMonitor);

        // 3. Use the composite object
        gamingPC.powerOn();

        // Manual Check for logic
        // This is just a simulation check
        if (gamingPC != null) {
            System.out.println("\n[PASS] Computer assembled and started successfully!");
        }
    }
}