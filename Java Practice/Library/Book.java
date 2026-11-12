package Library;

public class Book extends LibraryItem {
    private String author;   // the author of the book

    public Book(String title, String author, int totalCopies, int checkedOut) {
        super(title, totalCopies, checkedOut);
        if (author == null) {
            throw new NullPointerException();
        }
        this.author = author;
    }

    // Returns the author of this book.
    public String getAuthor() {
        return author;
    }

    public String getType() {
        return "Book";
    }

    public int getLoanDays() {
        return 21;
    }

    public double getDailyFine() {
        return 0.25;
    }

    // The LibraryItem text followed by the author, such as
    // Clean Code: 0 of 3 copies available (by Robert Martin)
    public String toString() {
        return super.toString() + " (by " + author + ")";
    }
    
}
