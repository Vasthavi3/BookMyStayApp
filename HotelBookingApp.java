public class HotelBookingApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingRequest request = new BookingRequest("Vasthavi", "Single");

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // 🔥 UC8 objects
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        String reservationId = "R101";

        if (request != null) {

            String roomType = request.getRoomType();

            System.out.println("Guest: " + request.getGuestName());
            System.out.println("Requested Room: " + roomType);

            if (inventory.allocateRoom(roomType)) {
                System.out.println("Reservation Confirmed!");

                // ✅ UC7
                serviceManager.addService(reservationId, new Service("Breakfast", 200));
                serviceManager.addService(reservationId, new Service("WiFi", 100));

                serviceManager.displayServices(reservationId);
                int totalCost = serviceManager.calculateTotalCost(reservationId);
                System.out.println("Total Add-On Cost: ₹" + totalCost);

                // 🔥 ================= UC8 START =================

                Reservation reservation = new Reservation(
                        reservationId,
                        request.getGuestName(),
                        roomType
                );

                history.addReservation(reservation);

                history.displayHistory();

                reportService.generateReport(history);

                // 🔥 ================= UC8 END =================

            } else {
                System.out.println("Room Not Available.");
            }
        }

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}