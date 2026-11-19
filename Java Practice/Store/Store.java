import java.util.*;

// An online store. It keeps all of its products, whatever their kind, in ONE ArrayList of type Product.
// Because Product is Comparable, the list can be sorted with Collections.sort and searched for its
// cheapest and most expensive product with Collections.min and Collections.max.
public class Store {
    private ArrayList<Product> products;   // every product of the store

    // Constructs a store with no products.
    public Store() {
        products = new ArrayList<Product>();
    }

    // Adds a product (a Grocery, an Electronics or a Clothing object) at the end of the list.
    // Precondition: product != null
    public void add(Product product) {
        if( product == null) {
            throw new NullPointerException();
        }
        products.add(product);
    }

    // Returns the number of products in the store.
    public int size() {
        return  products.size();

    }

    // Returns the first product with the given name (ignoring upper and lower case), or null if there is none.
    public Product find(String name) {
        for ( Product p : products) {
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    // Returns a NEW list that holds only the products of the given category, such as "Grocery".
    // The store itself is not changed.
    public ArrayList<Product> getByCategory(String category) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getCategory().equals(category)) {
                result.add(p);
            }
        }
        return result;
    }

    // Returns the value of all items in stock, including tax. Each product computes its own tax.
    public double getTotalStockValue() {
        double totals = 0.0;
        for(Product p : products) {
            totals += p.getStockValue();
        }
        return totals;
    }

    // Sorts the products from the cheapest to the most expensive (products with the same price by name).
    // Hint: the sort is one line, because Product has a compareTo method.
    public void sortByPrice() {
        Collections.sort(products);
    }

    // Returns the cheapest product (the smallest by compareTo), or null if the store has no products.
    public Product cheapest() {
        if (products.isEmpty()) {
            return null;
        }
        return Collections.min(products);
    }

    // Returns the most expensive product (the largest by compareTo), or null if the store has no products.
    public Product mostExpensive() {
        if (products.isEmpty()) {
            return null;
        }
        return Collections.max(products);
    }

    // Removes every product that is sold out (quantity 0) and returns how many were removed.
    // Hint: loop backward, so a removal only shifts products that were already checked.
    public int removeSoldOut() {
        int remove = 0;
        for (int i = products.size() - 1; i >= 0; i--) {
            if(products.get(i).getQuantity() == 0){
                products.remove(i);
                remove++;
            }

        }
        return remove;

    }

    // Returns one product per line, numbered from 1, such as
    // 1. Milk: $3.49, 12 in stock (expires in 7 days)
    public String toString() {
        String result = "";
        for (int i = 0; i < products.size(); i++) {
            result += (i + 1) + ". " + products.get(i) + "\n";
        }
        return result;
    }
}
