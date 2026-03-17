import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Handles reservation confirmation and room allocation.
 * Version: 6.0
 */
public class RoomAllocationService {
    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms; // roomType -> set of assigned room IDs
    private int roomIdCounter;

    public RoomAllocationService(RoomInventory inventory) {
        this.inventory = inventory;
        allocatedRooms = new HashMap<>();
        roomIdCounter = 1; // start room IDs from 1
    }

    // Allocate a room for a reservation
    public boolean allocateRoom(String guestName, String roomType) {
        int available = inventory.getAvailability(roomType);
        if (available <= 0) {
            System.out.println("No available rooms for " + guestName + " (" + roomType + ")");
            return false;
        }

        // Generate unique room ID
        String roomId = roomType.substring(0, 3).toUpperCase() + roomIdCounter++;

        // Track allocation
        allocatedRooms.putIfAbsent(roomType, new HashSet<>());
        Set<String> assignedIds = allocatedRooms.get(roomType);
        assignedIds.add(roomId);

        // Update inventory
        inventory.updateAvailability(roomType, available - 1);

        System.out.println("Reservation confirmed for " + guestName + " (" + roomType + ") - Assigned Room ID: " + roomId);
        return true;
    }

    // Display all allocated rooms
    public void displayAllocations() {
        System.out.println("\nAllocated Rooms:");
        for (Map.Entry<String, Set<String>> entry : allocatedRooms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}