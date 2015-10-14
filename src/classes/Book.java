package classes;

import java.util.Scanner;

/**
 * Created by piorkows on 10/12/2015.
 */
public class Book {
    int bookId;
    String bookTitle, bookAuthor, bookPublishingYear, bookISBN;
    Boolean isBookRented = false;

    /*public Book(int bookId,  String bookTitle, String bookAuthor, String bookPublishingYear, String bookISBN, Boolean isBookRented) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishingYear = bookPublishingYear;
        this.bookISBN = bookISBN;
        this.isBookRented = isBookRented;
    }*/

    public void getBookDetailsFromUser(){
        System.out.println("Enter book ID: ");
        Scanner userInputBookId = new Scanner(System.in);
        this.bookId= userInputBookId.nextInt();
        System.out.println("Enter book title: ");
        Scanner userInputBookTitle = new Scanner(System.in);
        this.bookTitle= userInputBookTitle.nextLine();
        System.out.println("Enter book author: ");
        Scanner userInputBookAuthor = new Scanner(System.in);
        this.bookAuthor= userInputBookAuthor.nextLine();
        System.out.println("Enter book publishing year: ");
        Scanner userInputBookPublishingYear = new Scanner(System.in);
        this.bookPublishingYear= userInputBookPublishingYear.nextLine();
        System.out.println("Enter book ISBN: ");
        Scanner userInputBookISBN = new Scanner(System.in);
        this.bookISBN= userInputBookISBN.nextLine();
    }

    public String newBookDetails(){
        return this.bookId + "|" + this.bookTitle + "|" + this.bookAuthor + "|" + this.bookPublishingYear + "|" + this.bookISBN + "|" + this.isBookRented+"\n";
    }
}
