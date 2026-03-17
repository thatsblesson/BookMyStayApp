import java.util.LinkedList;
import java.util.Queue;

/**
 * Main class for Use Case 11: Concurrent Booking Simulation
 * Version: 11.1
 */
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Double Room", 1);

        // Create booking queue with multiple guest reservations
        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Single Room"));
        bookingQueue.add(new Reservation("Charlie", "Double Room"));
        bookingQueue.add(new Reservation("Diana", "Single Room")); // will fail due to limited inventory
        bookingQueue.add(new Reservation("Eve", "Double Room")); // will fail

        // Create threads to process bookings concurrently
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory), "Thread-1");
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory), "Thread-2");

        t1.start();
        t2.start();

        // Wait for threads to finish
        t1.join();
        t2.join();

        // Display final inventory
        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();
    }
}
