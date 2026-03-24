class BookingValidator {

    public static void validate(String roomType, RoomInventory inventory) 
            throws InvalidBookingException {

        // ❌ Check invalid room type
        if (roomType == null || roomType.isEmpty()) {
            throw new InvalidBookingException("Room type cannot be empty!");
        }

        // ❌ Check if room exists
        if (!inventory.hasRoomType(roomType)) {
            throw new InvalidBookingException("Invalid room type selected!");
        }

        // ❌ Check availability
        if (!inventory.isAvailable(roomType)) {
            throw new InvalidBookingException("Room not available!");
        }
    }
}