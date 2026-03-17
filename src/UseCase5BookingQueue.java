/**
 * Main class for Use Case 5: First-Come-First-Served Booking Requests
 * Version: 5.1
 */
public class UseCase5BookingQueue {
    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate booking requests
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));
        bookingQueue.addRequest(new Reservation("Diana", "Single Room"));

        // Display queue
        bookingQueue.displayQueue();

        // Peek at the next request
        System.out.println("\nNext request to process: " + bookingQueue.peekNextRequest());

        // Process first request
        System.out.println("\nProcessing next request: " + bookingQueue.processNextRequest());

        // Display queue after processing
        bookingQueue.displayQueue();
    }
}