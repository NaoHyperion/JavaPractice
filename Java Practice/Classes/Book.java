public class Book {

    // TODO 1: Fields (reference lecture 8, section 8.4).
    // Declare three private fields: the title (a String), the number of copies the library owns
    // (an int), and the number of those copies that are checked out (an int).
    // Do not store the number of available copies. It can always be computed from the other two
    // values, so a stored value could become out of date.
    private String title;
    private int numCopies;
    private int numCheckedout;

    public Book(){
        this.title = "Blah";
        this.numCopies = 0;
        this.numCheckedout = 0;
    }
    
    public Book(String title,int numCopies, int numCheckedout){

        if (title == null) {
            throw new NullPointerException("Title shall not be blank!!!");
        }
        if (numCheckedout < 0 || numCheckedout > numCopies) {// now if its negative or bigger than the amount of books in storage there is a error
            throw new IllegalArgumentException("Checked out can't be negative or excede inventory");
        }


        this.title = title;
        this.numCopies = numCopies;
        this.numCheckedout = numCheckedout;
    }

    public String getTitle(){
        return title;
    }
    public int getAvailable(){
        int available = numCopies - numCheckedout;

        return available;
    }

    public String toString(){
        return "Title : " + title 
        + "Number of Copies : " + numCopies
        + "Checked out : " + numCheckedout;
    }



    // TODO 2: Constructor (reference lecture 8, sections 8.3 and 8.4).
    // Header:  public Book(String title, int totalCopies, int checkedOut)
    // The constructor runs each time the client writes new Book(title, totalCopies, checkedOut), once
    // for every row of the file. Store the three values in the fields (use this.title and so on,
    // because the parameters have the same names as the fields).
    // Protect the class invariant: throw a NullPointerException if the title is null, and an
    // IllegalArgumentException if checkedOut is negative or larger than totalCopies. A bad row in
    // the file should never become a Book object.


    // TODO 3: Accessors (reference lecture 8, section 8.2).
    // Header:  public String getTitle()
    // Returns the title of the book.
    //
    // Header:  public int getAvailable()
    // Returns the number of copies on the shelf that can be checked out: the total copies minus the
    // checked-out copies. Return the answer; do not print it.


    // TODO 4: toString (reference lecture 8, section 8.2).
    // Header:  public String toString()
    // Returns one line of text that describes the book, for example:
    //     Clean Code: 0 of 3 copies available
    // Return the text; do not print it. Java calls toString automatically when a Book is printed
    // or joined to a String.

}
