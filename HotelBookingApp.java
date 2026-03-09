import java.util.HashMap;
import java.util.Map;

public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay");
        System.out.println("Hotel Booking System v1.0");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);

        single.displayRoomDetails();
        System.out.println("Available: " + inventory.get("Single Room"));

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.get("Double Room"));

        suite.displayRoomDetails();
        System.out.println("Available: " + inventory.get("Suite Room"));
    }
}