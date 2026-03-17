import java.util.Queue;

/**
 * Processes booking requests concurrently with thread safety.
 * Version: 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {
    private Queue<Reservation> bookingQueue;
    private RoomInventory inventory;

    public ConcurrentBookingProcessor(Queue<Reservation> bookingQueue, RoomInventory inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            Reservation reservation;
            synchronized (bookingQueue) { // ensure only one thread accesses queue at a time
                if (bookingQueue.isEmpty()) {
                    break;
                }
                reservation = bookingQueue.poll();
            }

            // Allocate room safely
            synchronized (inventory) { // critical section for inventory update
                String roomType = reservation.getRequestedRoomType();
                int available = inventory.getAvailability(roomType);
                if (available > 0) {
                    inventory.updateAvailability(roomType, available - 1);
                    System.out.println(Thread.currentThread().getName() + " - Booking confirmed for " +
                            reservation.getGuestName() + " (" + roomType + ")");
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Booking failed for " +
                            reservation.getGuestName() + " (" + roomType + ") - No availability");
                }
            }
        }
    }
}