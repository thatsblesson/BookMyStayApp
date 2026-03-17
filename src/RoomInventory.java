import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RoomInventory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoomType(String type, int count) { inventory.put(type, count); }
    public int getAvailability(String type) { return inventory.getOrDefault(type, 0); }
    public void updateAvailability(String type, int count) { inventory.put(type, count); }
    public Map<String, Integer> getInventory() { return inventory; }

    public void displayInventory() {
        System.out.println("Room Inventory Status:");
        inventory.forEach((type, count) -> System.out.println(type + " - Available: " + count));
    }
}