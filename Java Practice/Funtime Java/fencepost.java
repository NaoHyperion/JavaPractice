public class fencepost {
    public static void main(String[] args) {
        System.out.print(1);
        for (int i = 2; i <= 10; i++) {
            System.out.print(","+ i);
        }
        System.out.println();
    }

    public static void multiprint(String s, int times) {
        System.out.print("["+ s);
        for( int i = 2; i <= times;  i++){
            System.out.print("," + s);//
        }
        System.out.println("]");
    }
    
}
