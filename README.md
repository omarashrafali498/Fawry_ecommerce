## Fawry E-Commerce System (Java)

This is a simplified Java-based e-commerce system that simulates key e-commerce operations like adding products to a cart, handling expirable and shippable products, checking out, and calculating shipping fees. The system is designed using the Strategy Design Pattern to avoid code duplication and enhance flexibility.

---

## Features

- Add products to cart with stock checking
- Handle different product types:
  - Expirable products (e.g., food)
  - Shippable products (e.g., physical items)
  - Non-shippable products (e.g., digital goods)
- Expiry date validation using `LocalDate`
- Shipping fee calculation based on total weight
- Clean checkout process with receipt generation

---

## Design Pattern Used

### Strategy Design Pattern

To avoid creating too many product subclasses, the Strategy Pattern is used to delegate behaviors like expiration and shipping to separate components.

---
## Example Usage

The Main class demonstrates the system with:

- Creating different types of products (with shipping/expiry configurations)
- Adding items to a cart
- Processing checkout

```java
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
```  

## Output Example
** Shipment notice **

1x Biscuits: 700g

Total package weight: 0.7kg

** Checkout receipt **

1x Biscuits: 150

2x Scratch Card: 200

Subtotal: 350

Shipping: 21

Amount: 371
