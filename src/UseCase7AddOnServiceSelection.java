/**
 * Main class for Use Case 7: Add-On Service Selection
 * Version: 7.1
 */
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Simulate reservation IDs
        String res1 = "SIN1"; // from UC6 allocations
        String res2 = "DOU3";
        String res3 = "SUI4";

        // Create services
        Service breakfast = new Service("Breakfast", 15.0);
        Service airportPickup = new Service("Airport Pickup", 25.0);
        Service spa = new Service("Spa Package", 50.0);

        // Add services to reservations
        serviceManager.addService(res1, breakfast);
        serviceManager.addService(res1, airportPickup);
        serviceManager.addService(res2, spa);
        serviceManager.addService(res3, breakfast);
        serviceManager.addService(res3, spa);

        // Display services for all reservations
        serviceManager.displayServices();

        // Calculate and display total cost for each reservation
        System.out.println("\nTotal Add-On Cost:");
        System.out.println(res1 + ": $" + serviceManager.calculateTotalCost(res1));
        System.out.println(res2 + ": $" + serviceManager.calculateTotalCost(res2));
        System.out.println(res3 + ": $" + serviceManager.calculateTotalCost(res3));
    }
}