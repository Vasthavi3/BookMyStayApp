/**
 * Main application entry point for the Hotel Booking System.
 * Demonstrates room inventory, room search, and booking request queue.
 */
public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v1.0");
        System.out.println("--------------------------------");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("\nAvailable Room Inventory:");
        inventory.displayInventory();

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        System.out.println("\nRoom Details:");

        if (inventory.getAvailability("Single Room") > 0) {
            singleRoom.displayRoomDetails();
        }

        if (inventory.getAvailability("Double Room") > 0) {
            doubleRoom.displayRoomDetails();
        }

        if (inventory.getAvailability("Suite Room") > 0) {
            suiteRoom.displayRoomDetails();
        }

        // UC5 Booking Request Queue
        System.out.println("\n--- Booking Request Queue ---");

        BookingRequestQueue queue = new BookingRequestQueue();

        BookingRequest r1 = new BookingRequest("Alice", "Single Room");
        BookingRequest r2 = new BookingRequest("Bob", "Suite Room");

        queue.addRequest(r1);
        queue.addRequest(r2);

        System.out.println("\nCurrent Booking Requests:");
        queue.displayRequests();

        System.out.println("\nProcessing Next Request:");
        queue.processRequest();

        System.out.println("\nRemaining Requests:");
        queue.displayRequests();
    }
}