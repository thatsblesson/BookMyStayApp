import java.util.ArrayList;
import java.util.List;

/**
 * Main class for Use Case 4: Room Search & Availability Check
 * Version: 4.0
 */
public class UseCase4RoomSearch {
    public static void main(String[] args) {
        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 0); // Suite unavailable

        // Initialize room objects
        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom(1, 50.0));
        rooms.add(new DoubleRoom(2, 80.0));
        rooms.add(new SuiteRoom(3, 150.0));

        // Initialize search service
        RoomSearchService searchService = new RoomSearchService(inventory, rooms);

        // Display available rooms
        searchService.displayAvailableRooms();
    }
}
