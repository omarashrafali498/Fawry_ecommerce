package m;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private Shippable shippable;
    private Expirable expirable;

    public Product(String name, double price, int quantity, Shippable shippable, Expirable expirable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippable = shippable;
        this.expirable = expirable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) {
        quantity -= amount;
    }

    public boolean isExpired() {
        return expirable.isExpired();
    }

    public boolean isShippable() {
        return shippable.isShippable();
    }

    public double getWeight() {
        return shippable.getWeight();
    }
}