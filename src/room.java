/**
 * Abstract Room class representing general room properties.
 * Version: 2.0
 */
public abstract class Room {
    protected String roomType;
    protected int numberOfBeds;
    protected double pricePerNight;

    public Room(String roomType, int numberOfBeds, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
    }

    // Abstract method to display room details
    public abstract void displayRoomDetails();
}