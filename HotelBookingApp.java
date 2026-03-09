public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay");
        System.out.println("Hotel Booking Management System");

        RoomInventory inventory = new RoomInventory();

        System.out.println("\nRoom Inventory:");
        inventory.displayInventory();

        String searchRoom = "Single Room";

        System.out.println("\nSearching for room: " + searchRoom);

        int available = inventory.getAvailability(searchRoom);

        if (available > 0) {
            System.out.println("Available Rooms: " + available);
        } else {
            System.out.println("Room not available");
        }
    }
}