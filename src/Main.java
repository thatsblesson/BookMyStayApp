/**
 * Main class for Use Case 2: Room Initialization
 * Version: 2.1
 */
public class UseCase2RoomInitialization {
    public static void main(String[] args) {
        // Static availability
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        // Initialize room objects
        Room singleRoom = new SingleRoom(1, 50.0);
        Room doubleRoom = new DoubleRoom(2, 80.0);
        Room suiteRoom = new SuiteRoom(3, 150.0);

        // Display room details and availability
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailable);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailable);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailable);
    }
}