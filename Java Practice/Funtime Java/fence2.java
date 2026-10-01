public class fence2 {
    public static void multiprint(String s, int times) {
        System.out.print("["+ s);
        for( int i = 2; i <= times;  i++){
            System.out.print("," + s);//
        }
        System.out.println("]");
    }
    
}
