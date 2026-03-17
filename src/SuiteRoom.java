public class SuiteRoom extends Room {
    public SuiteRoom(int numberOfBeds, double pricePerNight) {
        super("Suite Room", numberOfBeds, pricePerNight);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(roomType + " - Beds: " + numberOfBeds + ", Price: $" + pricePerNight);
    }
}