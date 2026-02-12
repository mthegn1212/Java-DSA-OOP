package oop_concepts.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // --- 1. THE OBSERVER INTERFACE ---
    // Anyone who wants to be notified must implement this
    interface Observer {
        void update(String message);
    }

    // --- 2. THE SUBJECT INTERFACE ---
    // The entity that generates events (The YouTube Channel)
    interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers(String message);
    }

    // --- 3. CONCRETE SUBJECT ---
    static class YouTubeChannel implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String channelName;

        public YouTubeChannel(String channelName) {
            this.channelName = channelName;
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
            System.out.println("-> New subscriber registered!");
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
            System.out.println("-> A subscriber has unsubscribed.");
        }

        @Override
        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

        // Business Logic: Upload a new video triggers notification
        public void uploadVideo(String videoTitle) {
            System.out.println("\n[CHANNEL] " + channelName + " is uploading: " + videoTitle);
            notifyObservers("New Video Alert: " + videoTitle + " on channel " + channelName);
        }
    }

    // --- 4. CONCRETE OBSERVER ---
    static class Subscriber implements Observer {
        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println("   [USER] " + name + " received: " + message);
        }
    }

    // --- MAIN PROGRAM ---
    public static void main(String[] args) {
        // 1. Create the Subject (Channel)
        YouTubeChannel myChannel = new YouTubeChannel("MixiGaming");

        // 2. Create Observers (Users)
        Subscriber user1 = new Subscriber("Alice");
        Subscriber user2 = new Subscriber("Bob");
        Subscriber user3 = new Subscriber("Charlie");

        // 3. Users subscribe to the channel
        myChannel.registerObserver(user1);
        myChannel.registerObserver(user2);
        myChannel.registerObserver(user3);

        // 4. Trigger Event: Upload Video 1
        myChannel.uploadVideo("Review iPhone 16");

        // 5. User 2 unsubscribes
        myChannel.removeObserver(user2);

        // 6. Trigger Event: Upload Video 2
        myChannel.uploadVideo("Vlog Du Lịch");

        // Manual Check logic is visual here, but let's assume it works if no exception
        System.out.println("\n[PASS] Observer Pattern demonstration finished.");
    }
}