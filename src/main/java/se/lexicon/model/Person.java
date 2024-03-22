package se.lexicon.model;


import java.util.Arrays;

public class Person {
    // todo: needs completion

    // Fields

    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;

    private Book[] borrowedBooks = new Book[0];

    // Constructor

    public Person(String firstName, String lastName) {
        this.id = getNextId();
        setFirstName(firstName);
        setLastName(lastName);
    }

    // Getters and setters

    public int getId(){
        return id;
    }
    private static int getNextId() {
        return ++sequencer;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("FirstName cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("LastName cannot be null");
        this.lastName = lastName;
    }

    public Book [] getBorrowedBooks(){
        return borrowedBooks;
    }

    //Method
    // Method for loan book
    public void loanBook(Book book) {

        if (book.isAvailable()) {
            book.setBorrower(this);

            Book[] newArrayOfBorrowedBooks = Arrays.copyOf(this.borrowedBooks, borrowedBooks.length + 1);
            newArrayOfBorrowedBooks[newArrayOfBorrowedBooks.length - 1] = book;
            borrowedBooks = newArrayOfBorrowedBooks;
        } else {
            throw new IllegalArgumentException("Book is not available.");
        }
    }
    public void returnBook(Book book) { // Method to return a borrowed book
        // Book cannot be null
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null"); // Throw an exception if the provided book is null
        }

        // If book is not null
        // Create a new array to store the updated list of borrowed books
        Book[] newArray = new Book[borrowedBooks.length - 1]; // Create a new array with size one less than the current borrowedBooks array
        int newArrayIndex = 0; // Index for the new array

        // Iterate through the borrowedBooks array using a normal for loop
        for (int i = 0; i < borrowedBooks.length; i++) { // Loop through each book in the borrowedBooks array
            // Check if the ID of the current book matches the ID of the book being returned
            if (borrowedBooks[i].getId().equals(book.getId())) { // If the ID of the current book matches the ID of the book being returned
                book.setBorrower(null); // Reset the borrower of the returned book to null
                continue; // Skip adding the returned book to the new array
            }
            // If the IDs do not match, add the current book to the new array
            newArray[newArrayIndex] = borrowedBooks[i]; // Add the current book to the new array
            newArrayIndex++; // Increment the index of the new array
        }

        // Update the borrowedBooks array to the new array
        borrowedBooks = newArray; // Assign the new array back to the borrowedBooks array, effectively removing the returned book
    }


    public String getPersonInformation() {
        return " ID: " + id + ", Name: " + firstName + " " + lastName + ",Number Of Borrowed Books: " + borrowedBooks.length;
    }








}









    //Methods for Get Person Information info



