public class SingleRoom extends Room {
    public SingleRoom(int numberOfBeds, double pricePerNight) {
        super("Single Room", numberOfBeds, pricePerNight);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(roomType + " - Beds: " + numberOfBeds + ", Price: $" + pricePerNight);
    }
}