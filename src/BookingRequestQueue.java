import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages booking requests using FIFO queue.
 * Version: 5.0
 */
public class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add a booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Booking request added for: " + reservation.getGuestName() +
                " (" + reservation.getRequestedRoomType() + ")");
    }

    // Peek at the next request without removing
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    // Process and remove the next request
    public Reservation processNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    // Display all requests in order
    public void displayQueue() {
        System.out.println("\nCurrent Booking Queue:");
        for (Reservation r : requestQueue) {
            System.out.println(r);
        }
    }
}