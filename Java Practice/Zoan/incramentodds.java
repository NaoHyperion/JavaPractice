package Zoan;

import Random.stars;

public class incramentodds {

    public static void main(String[] args) {
        int[] list = buildOddArray(5);
        incamentAll(list);

        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static int[] buildOddArray(int size){
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = 2 * i + 1;

        }
        return data;
    }

    public static void incamentAll(int[] data) {
        for (int i = 0; i < data.length; i++){
            data[i]++;
        }
    }
    
}
