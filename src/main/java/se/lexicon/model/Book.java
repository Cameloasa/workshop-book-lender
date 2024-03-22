package se.lexicon.model;

import java.util.UUID;

public class Book {
    //
    // Fields

private final String id; // borrower loan
private  String title;
private  String author;
private boolean available;
private Person borrower;

    // Constructors

    public Book(String title, String author) {
        //this(title, author, random);
        this.id = UUID.randomUUID().toString().substring(0,3);
        setTitle(title);
        setAuthor(author);
        setBorrower(null);
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        setBorrower(borrower);


    }
    // Getters and setters
    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

     public boolean isAvailable() {
        return available;
    }

     public Person getBorrower(){
        return borrower;
   }
    public void setBorrower(Person borrower) {

        this.borrower = borrower;
        this.available = (borrower == null);
    }
        // Methods
        // Method for get book info  id, title, Available
        public String getBookInformation() {

        String bookInfo = "ID: " + id + ",Title: " + title + " Available: " + available;
        if (borrower == null) {
        bookInfo = bookInfo + ", not borrowed";
        } else {
        bookInfo = bookInfo + " Borrower" + borrower.getPersonInformation();
         }

        return bookInfo;
    }




    }
