/**
 * Main class for Use Case 10: Booking Cancellation & Inventory Rollback
 * Version: 10.1
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Double Room", 1);

        // Simulate allocated rooms
        Map<String, Set<String>> allocatedRooms = new HashMap<>();
        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.put("Double Room", new HashSet<>());

        // Create reservations with IDs
        Reservation res1 = new Reservation("Alice", "Single Room");
        res1.setReservationID("R101");
        allocatedRooms.get("Single Room").add(res1.getReservationID());

        Reservation res2 = new Reservation("Bob", "Double Room");
        res2.setReservationID("R102");
        allocatedRooms.get("Double Room").add(res2.getReservationID());

        // Initialize cancellation service
        CancellationService cancellationService = new CancellationService(inventory, allocatedRooms);

        // Attempt cancellations
        cancellationService.cancelBooking(res1); // valid
        cancellationService.cancelBooking(res2); // valid

        // Attempt invalid cancellation
        Reservation fake = new Reservation("Charlie", "Single Room");
        fake.setReservationID("R999");
        cancellationService.cancelBooking(fake); // invalid

        // Display rollback stack
        cancellationService.viewRollbackStack();

        // Display updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}