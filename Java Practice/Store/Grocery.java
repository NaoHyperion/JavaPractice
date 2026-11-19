//what is this?? import java.lang.classfile.instruction.TableSwitchInstruction;

public class Grocery extends Product {
    public static final String CATEGORY = "Grocery";   // the category of this kind of product
    public static final double TAX_RATE = 0.0;          // the sales tax rate of this kind of product (a fraction)

    private int daysToExpire;   // the number of days until the product expires

    // Constructs a Grocery. Precondition: daysToExpire >= 0 (throw an IllegalArgumentException otherwise),
    // and the preconditions of Product.
    public Grocery(String name, double price, int quantity, int daysToExpire) {
        super(name,price,quantity);
        if(daysToExpire < 0){
            throw new IllegalArgumentException();
        }
        this.daysToExpire = daysToExpire;
    }

    @Override 
    public String getCategory() {
        return CATEGORY;
    }

    @Override 
    public double getTaxRate(){
        return TAX_RATE;
    }
    @Override 
    public String toString() {
        return super.toString() + " (expires in "+ daysToExpire + " days)";
    }
    //         getCategory() returns CATEGORY, getTaxRate() returns TAX_RATE, getDaysToExpire(),
    //         toString(): the Product text followed by the days to expire, such as
    //         Milk: $3.49, 12 in stock (expires in 7 days)
}
