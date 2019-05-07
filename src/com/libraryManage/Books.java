package src.com.libraryManage;

public class Books {
    book[] books;
    int num;

    public Books() {
        books = new book[10];
    }

    public int isExist(String Bookname) {
        for (int i = 0; i < num; i++) {
            if (books[i].getBookName() == Bookname)
                return i;
            else
                return -1;
        }
        return -1;
    }

    public boolean InTo(String BookName, String author) {
        if (num == books.length - 1) {

        }
        if (isExist(BookName) >= 0) {
            return false;
        } else {
            books[num].setBookName(BookName);
            books[num].setAuthor(author);
            num++;
            return true;
        }

    }
}
