package x;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product p, int quantity) {
        if (quantity > p.getQuantity()) {
            System.out.println("Error: Not enough stock for " + p.getName());
            return;
        }
        items.add(new CartItem(p, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<CartItem> getShippableItems() {
        List<CartItem> result = new ArrayList<>();
        for (CartItem item : items) {
            if (item.product.isShippable()) {
                result.add(item);
            }
        }
        return result;
    }
}
