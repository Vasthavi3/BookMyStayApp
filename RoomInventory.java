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

    // ✅ UC6: Allocate room
    public boolean allocateRoom(String roomType) {

        if (rooms.containsKey(roomType) && rooms.get(roomType) > 0) {
            rooms.put(roomType, rooms.get(roomType) - 1);
            return true;
        }

        return false;
    }

    // ✅ Display inventory (UC3)
    public void displayInventory() {

        System.out.println("Room Inventory:");

        for (String type : rooms.keySet()) {
            System.out.println(type + " : " + rooms.get(type));
        }
    }

    // 🔥 ================= UC9 METHODS (ADD ONLY) =================

    // Check if room type exists
    public boolean hasRoomType(String roomType) {
        return rooms.containsKey(roomType);
    }

    // Check if room is available
    public boolean isAvailable(String roomType) {
        return rooms.getOrDefault(roomType, 0) > 0;
    }

    // 🔥 ==========================================================
}