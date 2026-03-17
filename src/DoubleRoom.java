public class DoubleRoom extends Room {
    public DoubleRoom(int numberOfBeds, double pricePerNight) {
        super("Double Room", numberOfBeds, pricePerNight);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(roomType + " - Beds: " + numberOfBeds + ", Price: $" + pricePerNight);
    }
}