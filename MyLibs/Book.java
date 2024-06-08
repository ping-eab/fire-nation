/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibs;
/**
 *
 * @author Maglasang
 */
import java.util.Calendar;

public class Book {
    private String author;
    private String title;
    private Date pubDate;
    private Publisher publisher;

    public Book(String author, String title, Date pubDate, Publisher publisher) {
        this.author = author;
        this.title = title;
        this.pubDate = pubDate;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public static String convertMonth(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return months[month - 1];
        }
        return "Invalid Month";
    }

    public int checkBookAge() {
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int pubYear = pubDate.getYear();

        if (currentYear - pubYear >= 3) {
            return 0; // old book
        } else {
            return 1; // new book
        }
    }
}