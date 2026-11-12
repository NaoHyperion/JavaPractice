package Library;

public class Magazine extends LibraryItem {
    private String issue;   // the issue of the magazine, such as "Oct 2026"

    public Magazine(String title, String issue, int totalCopies, int checkedOut) {
                super(title,totalCopies,checkedOut);
                this.issue = issue;
    }
    public String getissue(){
        return issue;
    }

    @Override 
    public String getType() {
        return "Magazine";
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
        return super.toString() + issue + " Issue";
    }
}

