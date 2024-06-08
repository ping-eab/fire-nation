package MyApps;

import MyLibs.Address;
import MyLibs.Book;
import MyLibs.Date;
import MyLibs.Publisher;

/**
 * Test2 class to demonstrate book information display.
 * 
 * @author Maglasang
 */
public class Test2 {
  
    public static void main(String[] args) {
        Address publisherAddress1 = new Address(123, "London", "UK");
        Address publisherAddress2 = new Address(123, "New York", "USA");
        Address publisherAddress3 = new Address(123, "Chicago", "USA");
        
        Publisher publisher1 = new Publisher("Penguin", publisherAddress1);
        Publisher publisher2 = new Publisher("Scroll", publisherAddress2);
        Publisher publisher3 = new Publisher("Hambo", publisherAddress3);
        
        Date publicationDate1 = new Date(15, 9, 1977);
        Date publicationDate2 = new Date(24, 10, 1929);
        Date publicationDate3 = new Date(3, 9, 2018);
        
        Book book1 = new Book("J.R.R. Tolkien", "The Silmarillion", publicationDate1, publisher1);
        Book book2 = new Book ("Virginia Woolf", "A Room of One's Own", publicationDate2, publisher2);
        Book book3 = new Book ("Marceline Bubbs", "Monster in the Sweet-Toothed Kingdom",publicationDate3, publisher3);
        
        displayBookInfo(book1);
        displayBookInfo(book2);
        displayBookInfo(book3);
    }

    public static void displayBookInfo(Book book) {
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Publisher: " + book.getPublisher().getName());
        Address address = book.getPublisher().getAddress();
        System.out.println("Published Address: " + address.getNumber() + " " + address.getCity() + ", " + address.getCountry());
        System.out.println("Publication Date: " + book.getPubDate());
    }
}

   