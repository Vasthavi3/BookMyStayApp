import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<BookingRequest> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(BookingRequest request) {
        requestQueue.add(request);
        System.out.println("Booking request added for " + request.getGuestName());
    }

    // Process next request
    public BookingRequest processRequest() {

        if (requestQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return null;
        }

        BookingRequest request = requestQueue.poll();
        System.out.println("Processing request for " + request.getGuestName());

        return request;
    }

    // Display pending requests
    public void displayRequests() {

        if (requestQueue.isEmpty()) {
            System.out.println("No pending booking requests.");
            return;
        }

        System.out.println("Pending Booking Requests:");

        for (BookingRequest request : requestQueue) {
            request.displayRequest();
        }
    }
}