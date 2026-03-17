/**
 * Main class for Use Case 9: Error Handling & Validation
 * Version: 9.1
 */
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single Room", 2);
        inventory.addRoomType("Double Room", 1);
        inventory.addRoomType("Suite Room", 1);

        BookingValidator validator = new BookingValidator(inventory);

        String[] testGuests = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        String[] requestedRooms = {"Single Room", "Single Room", "Double Room", "Suite Room", "Penthouse"}; // Penthouse is invalid

        for (int i = 0; i < testGuests.length; i++) {
            String guest = testGuests[i];
            String roomType = requestedRooms[i];
            try {
                validator.validateRoomType(roomType);
                validator.validateAvailability(roomType);
                // Simulate booking (just decrement inventory for demonstration)
                inventory.updateAvailability(roomType, inventory.getAvailability(roomType) - 1);
                System.out.println("Booking confirmed for " + guest + " (" + roomType + ")");
            } catch (InvalidBookingException e) {
                System.out.println("Booking failed for " + guest + ": " + e.getMessage());
            }
        }

        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();
    }
}