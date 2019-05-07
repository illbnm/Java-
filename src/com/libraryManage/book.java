package src.com.libraryManage;
import java.util.Date;
public class book {
    private String  bookName;
    private String  author;
     Date  Datetime ;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatetime() {
        return Datetime;
    }

    public void setDatetime(Date datetime) {
        Datetime = datetime;
    }

    public book(String bookName , String author){
        this.bookName = bookName;
        this.author = author;
        Datetime = new Date();
    }
    public book(String bookName){
        this.bookName = bookName;
        Datetime = new Date();
    }
    public static void main(String[] args) {

    }
}
