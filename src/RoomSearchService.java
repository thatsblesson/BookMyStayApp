import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * RoomSearchService provides read-only search functionality for available rooms.
 * Version: 4.0
 */
public class RoomSearchService {
    private RoomInventory inventory;
    private List<Room> rooms;

    public RoomSearchService(RoomInventory inventory, List<Room> rooms) {
        this.inventory = inventory;
        this.rooms = rooms;
    }

    // Search available rooms
    public List<Room> searchAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            int availability = inventory.getAvailability(room.roomType);
            if (availability > 0) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Display available rooms
    public void displayAvailableRooms() {
        List<Room> availableRooms = searchAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        System.out.println("Available Rooms:");
        for (Room room : availableRooms) {
            room.displayRoomDetails();
            System.out.println("Available: " + inventory.getAvailability(room.roomType));
            System.out.println();
        }
    }
}