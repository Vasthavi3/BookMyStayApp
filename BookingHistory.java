import java.io.Serializable;
import java.util.*;

class BookingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Reservation> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    // ✅ Add reservation
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // ✅ Display history
    public void displayHistory() {

        System.out.println("\nBooking History:");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : reservations) {
            System.out.println(
                "ID: " + r.getReservationId() +
                " | Guest: " + r.getGuestName() +
                " | Room: " + r.getRoomType()
            );
        }
    }

    // ✅ Get all reservations (used in UC10 & UC12)
    public List<Reservation> getReservations() {
        return reservations;
    }
}