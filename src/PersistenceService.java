import java.io.*;

public class PersistenceService {

    // Save an object to a file
    public static void saveState(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("State saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    // Load an object from a file
    public static Object loadState(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println("State loaded from " + filename);
            return ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Persistence file not found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading state: " + e.getMessage());
        }
        return null;
    }
}
