import java.util.LinkedList;
import java.util.Queue;

/**
 * Main class for Use Case 6: Reservation Confirmation & Room Allocation
 * Version: 6.1
 */
public class UseCase6RoomAllocationService {
    public static void main(String[] args) {
        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Double Room", 1);
        inventory.addRoomType("Suite Room", 1);

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Single Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Double Room"));
        bookingQueue.addRequest(new Reservation("Diana", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Eve", "Single Room")); // Should fail, only 2 singles available

        // Initialize allocation service
        RoomAllocationService allocationService = new RoomAllocationService(inventory);

        // Process booking queue
        System.out.println("\nProcessing booking requests:\n");
        while (!bookingQueue.isEmpty()) {
            Reservation res = bookingQueue.processNextRequest();
            allocationService.allocateRoom(res.getGuestName(), res.getRequestedRoomType());
        }

        // Display final allocations and inventory
        allocationService.displayAllocations();
        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();
    }
}