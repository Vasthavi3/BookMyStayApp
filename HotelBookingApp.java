public class HotelBookingApp {

    public static void main(String[] args) {

        // ✅ Existing UC6 objects (DO NOT REMOVE)
        RoomInventory inventory = new RoomInventory();
        BookingRequest request = new BookingRequest("Vasthavi", "Single");

        if (request != null) {

            String roomType = request.getRoomType();

            System.out.println("Guest: " + request.getGuestName());
            System.out.println("Requested Room: " + roomType);

            if (inventory.allocateRoom(roomType)) {
                System.out.println("Reservation Confirmed!");

                // 🔥 ================= UC7 START =================

                AddOnServiceManager manager = new AddOnServiceManager();

                String reservationId = "R101";

                // Add multiple services
                manager.addService(reservationId, new Service("Breakfast", 200));
                manager.addService(reservationId, new Service("WiFi", 100));
                manager.addService(reservationId, new Service("Airport Pickup", 500));

                // Display services
                manager.displayServices(reservationId);

                // Calculate total cost
                int totalCost = manager.calculateTotalCost(reservationId);
                System.out.println("Total Add-On Cost: ₹" + totalCost);

                // 🔥 ================= UC7 END =================

            } else {
                System.out.println("Room Not Available.");
            }
        }

        // ✅ Existing UC6 output
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}