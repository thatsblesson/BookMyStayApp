/**
 * Main class for Use Case 8: Booking History & Reporting
 * Version: 8.1
 */
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService(history);

        // Simulate confirmed reservations
        Reservation res1 = new Reservation("Alice", "Single Room");
        Reservation res2 = new Reservation("Bob", "Single Room");
        Reservation res3 = new Reservation("Charlie", "Double Room");
        Reservation res4 = new Reservation("Diana", "Suite Room");

        // Add to history
        history.addReservation(res1);
        history.addReservation(res2);
        history.addReservation(res3);
        history.addReservation(res4);

        // Display full booking history
        reportService.displayAllBookings();

        // Display summary by room type
        reportService.displaySummaryByRoomType();
    }
}