import java.util.ArrayList;
import java.util.List;

public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        // Step 1: Load previous state if available
        RoomInventory inventory = (RoomInventory) PersistenceService.loadState("inventory.dat");
        List<Reservation> bookingHistory = (List<Reservation>) PersistenceService.loadState("bookings.dat");

        if (inventory == null) inventory = new RoomInventory();
        if (bookingHistory == null) bookingHistory = new ArrayList<>();

        // Step 2: Initialize inventory if empty
        if (inventory.getInventory().isEmpty()) {
            inventory.addRoomType("Single Room", 2);
            inventory.addRoomType("Double Room", 1);
        }

        // Step 3: Simulate a new reservation
        Reservation newBooking = new Reservation("Frank", "Single Room");
        if (inventory.getAvailability(newBooking.getRequestedRoomType()) > 0) {
            inventory.updateAvailability(newBooking.getRequestedRoomType(),
                    inventory.getAvailability(newBooking.getRequestedRoomType()) - 1);
            bookingHistory.add(newBooking);
            System.out.println("Booking confirmed for " + newBooking.getGuestName());
        } else {
            System.out.println("Booking failed for " + newBooking.getGuestName());
        }

        // Step 4: Display current inventory
        inventory.displayInventory();

        // Step 5: Save state before exit
        PersistenceService.saveState(inventory, "inventory.dat");
        PersistenceService.saveState(bookingHistory, "bookings.dat");
    }
}