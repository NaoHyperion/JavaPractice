public class Electronics extends Product {
    public static final String CATEGORY = "Electronics";   // the category of this kind of product
    public static final double TAX_RATE = 0.08;          // the sales tax rate of this kind of product (a fraction)

    private int warrantyMonths;   // the length of the warranty in months

    // Constructs an Electronics product. Precondition: warrantyMonths >= 0 (throw an IllegalArgumentException
    // otherwise), and the preconditions of Product.
    public Electronics(String name, double price, int quantity, int warrantyMonths) {
        super(name,price,quantity);
        if(warrantyMonths < 0){
            throw new IllegalArgumentException();
        }
        this.warrantyMonths = warrantyMonths;
        ///Just like the last one
    }


    @Override 
    public String getCategory(){
        return CATEGORY;
    }

    @Override 
    public double getTaxRate(){
        return TAX_RATE;
    }

    public int getWarrantyMonths(){
        return warrantyMonths;
    }

    @Override 
    public String toString(){
        return super.toString() + " (" + warrantyMonths + "-month warranty)";
    }

    //         getCategory() returns CATEGORY, getTaxRate() returns TAX_RATE, getWarrantyMonths(),
    //         toString(): the Product text followed by the warranty, such as
    //         Webcam: $39.50, 0 in stock (12-month warranty)
}
