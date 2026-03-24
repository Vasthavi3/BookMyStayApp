import java.util.HashMap;
import java.util.Map;

class RoomInventory {

    private Map<String, Integer> rooms;

    public RoomInventory() {
        rooms = new HashMap<>();

        // ✅ Initial room setup (UC2/UC3)
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    // 🔥 UC11: THREAD-SAFE METHOD (IMPORTANT)
    public synchronized boolean allocateRoom(String roomType) {

        if (rooms.containsKey(roomType) && rooms.get(roomType) > 0) {
            rooms.put(roomType, rooms.get(roomType) - 1);
            return true;
        }

        return false;
    }

    // ✅ UC3: Display inventory
    public void displayInventory() {

        System.out.println("Room Inventory:");

        for (String type : rooms.keySet()) {
            System.out.println(type + " : " + rooms.get(type));
        }
    }

    // 🔥 UC9 METHODS

    public boolean hasRoomType(String roomType) {
        return rooms.containsKey(roomType);
    }

    public boolean isAvailable(String roomType) {
        return rooms.getOrDefault(roomType, 0) > 0;
    }

    // 🔥 UC10 METHOD (Rollback)
    public void releaseRoom(String roomType) {
        rooms.put(roomType, rooms.getOrDefault(roomType, 0) + 1);
    }
}