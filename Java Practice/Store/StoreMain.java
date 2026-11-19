import java.util.*;

public class StoreMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        giveIntro();

        Store store = buildStore();
        lookupProduct(store, console);
        printByCategory(store, console);
        sortByPrice(store);
        removeSoldOut(store);

        console.close();
    }

    public static void giveIntro() {
        System.out.println("This program manages the products of an online store.");
        System.out.println("The products are kept in an ArrayList, sorted by price, and cleaned of sold-out items.");
        System.out.println();
    }

    // Builds the store with ten products. Every one is stored in the list of Product objects.
    // new Product(...) would not compile: Product is abstract.
    public static Store buildStore() {
        Store store = new Store();
        store.add(new Grocery("Milk", 3.49, 12, 7));
        store.add(new Grocery("Bread", 2.49, 20, 4));
        store.add(new Grocery("Apples", 2.49, 0, 10));
        store.add(new Grocery("Eggs", 4.29, 8, 14));
        store.add(new Electronics("Charger", 19.99, 15, 12));
        store.add(new Electronics("Headphones", 59.99, 6, 24));
        store.add(new Electronics("Webcam", 39.50, 0, 12));
        store.add(new Clothing("T-Shirt", 14.99, 25, "M"));
        store.add(new Clothing("RainJacket", 49.00, 4, "L"));
        store.add(new Clothing("Socks", 6.99, 30, "One size"));
        return store;
    }

    // Prints all products, asks for a product name and prints the product, or a message if there is none.
    public static void lookupProduct(Store store, Scanner console) {
        System.out.println("The store has " + store.size() + " products:");
        System.out.print(store);
        System.out.println();

        System.out.print("Look up which product? ");
        String name = console.next();
        Product found = store.find(name);
        if (found == null) {
            System.out.println("There is no product named " + name + ".");
        } else {
            System.out.println("Found: " + found);
        }
        System.out.println();
    }

    // Asks for a category and prints the products of that category.
    public static void printByCategory(Store store, Scanner console) {
        System.out.print("Which category (" + Grocery.CATEGORY + ", " + Electronics.CATEGORY + " or " + Clothing.CATEGORY + ")? ");
        String category = console.next();
        ArrayList<Product> list = store.getByCategory(category);
        System.out.println("The " + list.size() + " products in " + category + ":");
        printList(list);
        System.out.println();
    }

    // Sorts the store by price and prints the sorted products, the cheapest and the most expensive.
    public static void sortByPrice(Store store) {
        store.sortByPrice();
        System.out.println("From cheapest to most expensive:");
        System.out.println(store);
        if(store.size() > 0){
            System.out.println("Cheapest: "+ store.cheapest().getName());
            System.out.println("Most Expensive: " + store.mostExpensive().getName());
        }
        System.out.println();//Space!
    }

    // Removes the sold-out products and prints how many were removed and the stock value of the rest.
    public static void removeSoldOut(Store store) {
        int removed = store.removeSoldOut();
        System.out.println(removed + " sold-out products were removed. " + store.size() + " products are left.");
        System.out.printf("Stock value of the products left, including tax: $%.2f%n", store.getTotalStockValue());
    }

    // Prints one product per line, indented by two spaces, or "(none)" if the list is empty.
    public static void printList(ArrayList<Product> list) {
        if(list.isEmpty()) {
            System.out.println(" (none)");
            return;
        }
        for (Product p : list) {
            System.out.println(" " + p );
        }
    }
}
