import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Handles safe cancellation of confirmed bookings.
 * Version: 10.0
 */
public class CancellationService {
    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms; // roomType -> room IDs
    private Stack<String> rollbackStack; // track released room IDs

    public CancellationService(RoomInventory inventory, Map<String, Set<String>> allocatedRooms) {
        this.inventory = inventory;
        this.allocatedRooms = allocatedRooms;
        this.rollbackStack = new Stack<>();
    }

    // Cancel a booking for a given reservation
    public void cancelBooking(Reservation reservation) {
        String roomType = reservation.getRequestedRoomType();
        Set<String> allocated = allocatedRooms.get(roomType);

        if (allocated == null || !allocated.contains(reservation.getReservationID())) {
            System.out.println("Cancellation failed: Reservation does not exist or already cancelled for " + reservation.getGuestName());
            return;
        }

        // Remove reservation and rollback inventory
        allocated.remove(reservation.getReservationID());
        rollbackStack.push(reservation.getReservationID());
        inventory.updateAvailability(roomType, inventory.getAvailability(roomType) + 1);

        System.out.println("Booking cancelled for " + reservation.getGuestName() + " (" + roomType + ")");
    }

    // Optionally view rollback stack
    public void viewRollbackStack() {
        System.out.println("Rollback Stack (most recent first): " + rollbackStack);
    }
}