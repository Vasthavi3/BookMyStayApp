import java.util.*;

class AddOnServiceManager {

    private Map<String, List<Service>> reservationServices = new HashMap<>();

    // Add service to reservation
    public void addService(String reservationId, Service service) {
        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    // Display services
    public void displayServices(String reservationId) {
        List<Service> services = reservationServices.get(reservationId);

        if (services != null) {
            System.out.println("Add-On Services:");
            for (Service s : services) {
                System.out.println(s.getName() + " - ₹" + s.getPrice());
            }
        }
    }

    // Calculate total cost
    public int calculateTotalCost(String reservationId) {
        int total = 0;

        List<Service> services = reservationServices.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.getPrice();
            }
        }

        return total;
    }
}