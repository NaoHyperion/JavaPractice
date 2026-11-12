package Library;

public abstract class LibraryItem {
    private String title;       // the title of the item
    private int totalCopies;    // number of copies the library owns
    private int checkedOut;     // number of those copies that are checked out

    // Constructs an item with the given title, number of copies and number of checked-out copies.
    // Precondition: title != null && 0 <= checkedOut <= totalCopies
    public LibraryItem(String title, int totalCopies, int checkedOut) {
        if (title == null) {
            throw new NullPointerException();
        }
        if (checkedOut < 0 || checkedOut > totalCopies) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.totalCopies = totalCopies;
        this.checkedOut = checkedOut;
    }

    // Returns the title of this item.
    public String getTitle() {
        return title;
    }

    // Returns the number of copies that are on the shelf and can be checked out.
    public int getAvailable() {
        return totalCopies - checkedOut;
    }

    // Returns the kind of item, such as "Book". Every subclass must write this method.
    public abstract String getType();

    // Returns the number of days this kind of item may be kept. Every subclass must write this method.
    public abstract int getLoanDays();

    // Returns the fine, in dollars, for each day this kind of item is returned late.
    // Every subclass must write this method.
    public abstract double getDailyFine();

    // Returns the late fee, in dollars, when the item is returned daysLate days after the due date.
    // An item that is not late (daysLate <= 0) costs nothing. This method is written once; the call
    // to getDailyFine() runs the version of the actual object (a Book, a Dvd or a Magazine).
    public double getLateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0.0;
        }
        return daysLate * getDailyFine();
    }

    // Returns a String such as "Clean Code: 0 of 3 copies available".
    public String toString() {
        return title + ": " + getAvailable() + " of " + totalCopies + " copies available";
    }
}
