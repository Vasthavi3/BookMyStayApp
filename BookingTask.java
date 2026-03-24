class BookingTask implements Runnable {

    private RoomInventory inventory;
    private String guestName;
    private String roomType;

    public BookingTask(RoomInventory inventory, String guestName, String roomType) {
        this.inventory = inventory;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + 
                " trying to book for " + guestName);

        if (inventory.allocateRoom(roomType)) {
            System.out.println("✅ Booking confirmed for " + guestName);
        } else {
            System.out.println("❌ Booking failed for " + guestName);
        }
    }
}