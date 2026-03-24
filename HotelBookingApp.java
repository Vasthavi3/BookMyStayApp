public class HotelBookingApp {

    public static void main(String[] args) {

        // ✅ Core objects (UC6)
        RoomInventory inventory = new RoomInventory();
        BookingRequest request = new BookingRequest("Vasthavi", "Single");

        // ✅ UC7
        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // ✅ UC8
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // ✅ UC10
        CancellationService cancelService = new CancellationService();

        String reservationId = "R101";

        try {

            // 🔥 UC9 Validation
            if (request == null) {
                throw new InvalidBookingException("Booking request is null!");
            }

            String roomType = request.getRoomType();

            BookingValidator.validate(roomType, inventory);

            // ✅ Display request
            System.out.println("Guest: " + request.getGuestName());
            System.out.println("Requested Room: " + roomType);

            // ✅ Booking (UC6)
            if (inventory.allocateRoom(roomType)) {

                System.out.println("Reservation Confirmed!");

                // 🔥 ================= UC7 =================
                serviceManager.addService(reservationId, new Service("Breakfast", 200));
                serviceManager.addService(reservationId, new Service("WiFi", 100));
                serviceManager.addService(reservationId, new Service("Airport Pickup", 500));

                serviceManager.displayServices(reservationId);

                int totalCost = serviceManager.calculateTotalCost(reservationId);
                System.out.println("Total Add-On Cost: ₹" + totalCost);

                // 🔥 ================= UC8 =================
                Reservation reservation = new Reservation(
                        reservationId,
                        request.getGuestName(),
                        roomType
                );

                history.addReservation(reservation);

                history.displayHistory();

                reportService.generateReport(history);

                // 🔥 ================= UC10 =================
                cancelService.cancelReservation(reservationId, history, inventory);

                cancelService.displayRollbackStack();
            }

        } catch (InvalidBookingException e) {

            // 🔥 UC9 Error Handling
            System.out.println("Booking Failed: " + e.getMessage());
        }

        // ✅ Final inventory state
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}