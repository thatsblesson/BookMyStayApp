import java.util.Arrays;
import java.util.List;

/**
 * Validates booking input and system state.
 * Version: 9.0
 */
public class BookingValidator {
    private RoomInventory inventory;
    private List<String> validRoomTypes = Arrays.asList("Single Room", "Double Room", "Suite Room");

    public BookingValidator(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Validate room type exists
    public void validateRoomType(String roomType) throws InvalidBookingException {
        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }
    }

    // Validate sufficient availability
    public void validateAvailability(String roomType) throws InvalidBookingException {
        int available = inventory.getAvailability(roomType);
        if (available <= 0) {
            throw new InvalidBookingException("No available rooms for type: " + roomType);
        }
    }
}