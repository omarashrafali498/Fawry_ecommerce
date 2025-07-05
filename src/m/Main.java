package m;

public class Main {
    public static void main(String[] args) {
        Product biscuits = new Product("Biscuits", 150, 5,
            new HasShipping(0.7),
            new HasExpiry("2025-07-10")
        );

        Product scratchCard = new Product("Scratch Card", 100, 10,
            new NoShipping(),
            new NoExpiry()
        );

        Cart cart = new Cart();
        cart.add(biscuits, 2);
        cart.add(scratchCard, 1);

        Customer customer = new Customer("Ali", 1000);
        customer.checkout(cart);
    }
}