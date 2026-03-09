public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay");
        System.out.println("Hotel Booking Management System");

        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue queue = new BookingRequestQueue();

        BookingRequest r1 = new BookingRequest("Alice", "Single Room");
        BookingRequest r2 = new BookingRequest("Bob", "Suite Room");

        queue.addRequest(r1);
        queue.addRequest(r2);

        System.out.println("\nProcessing Booking Requests...\n");

        BookingRequest request = queue.processRequest();

        if (request != null) {

            String roomType = request.getRoomType();

            System.out.println("Guest: " + request.getGuestName());
            System.out.println("Requested Room: " + roomType);

            if (inventory.allocateRoom(roomType)) {
                System.out.println("Reservation Confirmed!");
            } else {
                System.out.println("Room Not Available.");
            }
        }

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}