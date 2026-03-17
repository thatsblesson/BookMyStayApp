/**
 * Main class for Use Case 3: Centralized Room Inventory Management
 * Version: 3.1
 */
public class UseCase3InventorySetup {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();

        // Register room types with initial availability
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 2);

        // Display inventory state
        inventory.displayInventory();

        // Example update: One single room booked
        inventory.updateAvailability("Single Room", inventory.getAvailability("Single Room") - 1);
        System.out.println("\nAfter booking 1 Single Room:");
        inventory.displayInventory();
    }
}