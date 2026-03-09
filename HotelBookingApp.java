public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Hotel Booking System v1.0");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\nRoom Details:");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);

    }
}