class BookingReportService {

    public void generateReport(BookingHistory history) {

        int totalBookings = history.getReservations().size();

        System.out.println("\n📊 Booking Report");
        System.out.println("Total Reservations: " + totalBookings);
    }
}