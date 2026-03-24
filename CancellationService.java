
import java.util.*;

class CancellationService {

    private Stack<String> rollbackStack = new Stack<>();
    private Set<String> cancelledReservations = new HashSet<>();

    public void cancelReservation(String reservationId,
                                  BookingHistory history,
                                  RoomInventory inventory) {

        // ❌ Check if already cancelled
        if (cancelledReservations.contains(reservationId)) {
            System.out.println("Cancellation Failed: Already cancelled!");
            return;
        }

        // 🔍 Find reservation
        Reservation found = null;

        for (Reservation r : history.getReservations()) {
            if (r.getReservationId().equals(reservationId)) {
                found = r;
                break;
            }
        }

        // ❌ If not found
        if (found == null) {
            System.out.println("Cancellation Failed: Reservation not found!");
            return;
        }

        // 🔥 Rollback process
        rollbackStack.push(reservationId);

        // Restore inventory
        inventory.releaseRoom(found.getRoomType());

        cancelledReservations.add(reservationId);

        System.out.println("Reservation " + reservationId + " cancelled successfully!");
    }

    public void displayRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}