// One kind of product that the store sells. Product is abstract: every real product is a Grocery,
// an Electronics or a Clothing object. Products are Comparable: their natural order is from the
// cheapest to the most expensive, and products with the same price are ordered by name.
public abstract class Product implements Comparable<Product> {
    private String name;      // the name of the product
    private double price;     // the price of one item in dollars, before tax
    private int quantity;     // the number of items in stock

    // Constructs a product with the given name, price and quantity in stock.
    // Precondition: name != null && price >= 0.0 && quantity >= 0
    public Product(String name, double price, int quantity) {
        if (name == null) {
            throw new NullPointerException();
        }
        if (price < 0.0 || quantity < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Returns the name of this product.
    public String getName() {
        return name;
    }

    // Returns the price of one item in dollars, before tax.
    public double getPrice() {
        return price;
    }

    // Returns the number of items in stock.
    public int getQuantity() {
        return quantity;
    }

    // Returns the kind of product, such as "Grocery". Every subclass must write this method.
    public abstract String getCategory();

    // Returns the sales tax rate of this kind of product as a fraction, such as 0.08 for 8%.
    // Every subclass must write this method.
    public abstract double getTaxRate();

    // Returns the price of one item including tax.
    public double getPriceWithTax() {
        return price * (1 + getTaxRate());
    }

    // Returns the value of everything in stock, including tax: quantity * price with tax.
    public double getStockValue() {
        return quantity * getPriceWithTax();
    }

    // Compares this product with another product for Collections.sort, min and max:
    // the cheaper product comes first; when the prices are equal, the name decides (alphabetical order).
    // Returns a negative number if this product comes before other, 0 if they have the same price and name,
    // and a positive number if this product comes after other.
    @Override
    public int compareTo(Product other) {
        int result = Double.compare(price, other.price);
        if (result != 0){
            return result;
        }
        return name.compareTo(other.name);
    }

    // Returns text such as: Milk: $3.49, 12 in stock
    public String toString() {
        return name + ": $" + String.format("%.2f", price) + ", " + quantity + " in stock";
    }
}
