import java.util.ArrayList;
import java.util.List;

/**
 * Maintains a history of confirmed bookings.
 * Version: 8.0
 */
public class BookingHistory {
    private List<Reservation> confirmedBookings;

    public BookingHistory() {
        confirmedBookings = new ArrayList<>();
    }

    // Add a confirmed reservation to history
    public void addReservation(Reservation reservation) {
        confirmedBookings.add(reservation);
        System.out.println("Added confirmed reservation: " + reservation.getGuestName() + " (" + reservation.getRequestedRoomType() + ")");
    }

    // Retrieve all confirmed reservations
    public List<Reservation> getConfirmedBookings() {
        return new ArrayList<>(confirmedBookings); // return a copy to prevent modification
    }
}