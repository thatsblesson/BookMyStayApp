import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages add-on services for reservations.
 * Version: 7.0
 */
public class AddOnServiceManager {
    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    // Add a service to a reservation
    public void addService(String reservationId, Service service) {
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);
        System.out.println("Added " + service + " to reservation " + reservationId);
    }

    // Get total cost of add-ons for a reservation
    public double calculateTotalCost(String reservationId) {
        List<Service> services = reservationServices.getOrDefault(reservationId, new ArrayList<>());
        return services.stream().mapToDouble(Service::getServiceCost).sum();
    }

    // Display all services for all reservations
    public void displayServices() {
        System.out.println("\nAdd-On Services per Reservation:");
        for (Map.Entry<String, List<Service>> entry : reservationServices.entrySet()) {
            System.out.println("Reservation " + entry.getKey() + ": " + entry.getValue());
        }
    }
}