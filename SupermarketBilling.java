import java.util.ArrayList;
import java.util.Scanner;

public class SupermarketBilling {
    private static final double TAX_RATE = 0.08;
    private static ArrayList<Item> cart = new ArrayList<Item>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the menu
            System.out.println("Menu:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            // Prompt the user to select an option
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add item to cart
                    addItemToCart();
                    break;
                case 2:
                    // Remove item from cart
                    removeItemFromCart();
                    break;
                case 3:
                    // View cart
                    viewCart();
                    break;
                case 4:
                    // Checkout
                    checkout();
                    break;
                case 5:
                    // Exit
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addItemToCart() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the item details
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();

        // Add the item to the cart
        Item item = new Item(name, price, quantity);
        cart.add(item);

        System.out.println("Item added to cart.");
    }

    private static void removeItemFromCart() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the item name
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        // Remove the item from the cart
        for (Item item : cart) {
            if (item.getName().equals(name)) {
                cart.remove(item);
                System.out.println("Item removed from cart.");
                return;
            }
        }

        System.out.println("Item not found in cart.");
    }

    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Cart:");
        double subtotal = 0;
        for (Item item : cart) {
            System.out.println(item.getName() + " x " + item.getQuantity() + " @ $" + item.getPrice());
            subtotal += item.getPrice() * item.getQuantity();
        }

        double tax = subtotal * TAX_RATE;
        double total = subtotal + tax;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax: $" + tax);
        System.out.println("Total: $" + total);
    }

    private static void checkout() {
        viewCart();
        cart.clear();
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
}

   
