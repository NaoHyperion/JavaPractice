package movieSeats;

public class Negative {
    public static void main(String[] args) {
        f
    }
    
}


public static void negative)(DrawingPanel panel) {
    color[][] pixels = panel.getPixels();
    for (int row = 0; row < pixels.length; row++) {
        for (int col = 0; col < pixels.length; col++) {
            int r = 255 - pixels[row][col].getRed();
            int g = 255 - pixels[row][col].getGreen();
            int b = 255 - pixels[row][col].getBlue();
            pixels[col][row] = new Color(r,g,b);
        }
    }
}