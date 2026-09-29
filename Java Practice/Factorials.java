public class Factorials {

    public static int factorial (int n) {
        if (n< 0) {
        throw new IllegalArgumentException("Negative n:" + n);
    }
    //^^^^ Precondition check

    int product = 1;
    for (int i = 2; i <= n; i++){
        product = product * i;
    }
    return product;
}
    
}
