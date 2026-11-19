public class Clothing extends Product {
    public static final String CATEGORY = "Clothing";   // the category of this kind of product
    public static final double TAX_RATE = 0.06;          // the sales tax rate of this kind of product (a fraction)

    private String size;   // the size of the clothing, such as "M" or "One size"

    // Constructs a Clothing product. Precondition: size != null (throw a NullPointerException otherwise),
    // and the preconditions of Product.
    public Clothing(String name, double price, int quantity, String size) {
        super(name,price,quantity);
        if(size == null){
            throw new NullPointerException();
        }
        this.size = size;
    }

    @Override 
    public String getCategory(){
        return CATEGORY;
    }
    @Override 
    public double getTaxRate(){
        return TAX_RATE;
    }
    public String getString(){
        return size;
    }
    @Override
    public String toString(){
        return super.toString() + "(size " + size + ")";
    }
}
