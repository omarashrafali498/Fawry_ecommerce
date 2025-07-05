package m;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void checkout(Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                System.out.println("Error: " + item.product.getName() + " is expired.");
                return;
            }

            if (item.quantity > item.product.getQuantity()) {
                System.out.println("Error: Not enough stock for " + item.product.getName());
                return;
            }
        }

        double subtotal = cart.calculateSubtotal();
        double shipping = ShippingService.shipItems(cart.getShippableItems());
        double total = subtotal + shipping;

        if (total > balance) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        balance -= total;
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.0f\n", subtotal);
        System.out.printf("Shipping\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", total);
    }
}