public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay");
        System.out.println("Hotel Booking Management System");

        RoomInventory inventory = new RoomInventory();

        System.out.println("\nRoom Inventory:");
        inventory.displayInventory();
    }
}