package m;

import java.util.List;

public class ShippingService {
    public static double shipItems(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (CartItem item : items) {
            double weight = item.product.getWeight() * item.quantity;
            System.out.printf("%dx %s\t%.0fg\n", item.quantity, item.product.getName(), weight * 1000);
            totalWeight += weight;
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
        return totalWeight * 30;
    }
}