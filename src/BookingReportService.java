import java.util.List;

/**
 * Generates reports from booking history.
 * Version: 8.0
 */
public class BookingReportService {
    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Display all confirmed bookings
    public void displayAllBookings() {
        List<Reservation> bookings = history.getConfirmedBookings();
        System.out.println("\nBooking History Report:");
        if (bookings.isEmpty()) {
            System.out.println("No confirmed reservations yet.");
            return;
        }
        for (Reservation res : bookings) {
            System.out.println("Guest: " + res.getGuestName() + ", Room Type: " + res.getRequestedRoomType());
        }
    }

    // Display total bookings by room type
    public void displaySummaryByRoomType() {
        List<Reservation> bookings = history.getConfirmedBookings();
        System.out.println("\nBooking Summary by Room Type:");
        if (bookings.isEmpty()) {
            System.out.println("No confirmed reservations yet.");
            return;
        }

        // Count bookings per room type
        java.util.Map<String, Integer> summary = new java.util.HashMap<>();
        for (Reservation res : bookings) {
            summary.put(res.getRequestedRoomType(), summary.getOrDefault(res.getRequestedRoomType(), 0) + 1);
        }

        summary.forEach((roomType, count) -> System.out.println(roomType + ": " + count + " bookings"));
    }
}