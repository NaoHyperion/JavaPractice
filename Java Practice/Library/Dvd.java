package Library;

public class Dvd extends LibraryItem {
    private int minutes;   // the running time of the DVD, in minutes

    public Dvd(String title, int minutes, int totalCopies, int checkedOut) {
        super(title,totalCopies,checkedOut);
        this.minutes =minutes;
    }

    // minteues, type(dvd book mag)
    public int getMinutes(){
        return minutes;
    }



    @Override 
    public String getType() {
        return "DVD";
    }
    @Override 
    public int getLoanDays() {
        return 21;
    }

    public double getDailyFine(){
        return 0.25;
    }

    @Override
    public String toString(){
        return super.toString() + " " + minutes + " minutues";
    }
}
