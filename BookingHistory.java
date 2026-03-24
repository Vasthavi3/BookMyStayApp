import java.util.*;

class BookingHistory {

    private List<Reservation> reservations = new ArrayList<>();

    // Add reservation
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Display history
    public void displayHistory() {
        System.out.println("\nBooking History:");

        for (Reservation r : reservations) {
            System.out.println("ID: " + r.getReservationId() +
                    " | Guest: " + r.getGuestName() +
                    " | Room: " + r.getRoomType());
        }
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}