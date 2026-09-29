public class random {

    public static void main(String[] args){
        int z = (int)(Math.random() * 10) + 1;
        int b = (int)(Math.random() * 10) + 1;
        int y = (int)(Math.random() * 10) + 1;
        System.out.println(z);
        System.out.println(b);
        System.out.println(y);

        double hypon = Math.sqrt(Math.pow(z,2))  + (Math.pow(b,2));

        System.out.println(hypon);
    }
    
}
