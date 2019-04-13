package soup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import static org.jsoup.Jsoup.*;
import java.io.*;
public class mySoup {
    public static void main(String[] args) {
        try {

            Document doc = Jsoup.connect("https://www.taobao.com" ).get();
            String title = doc.html();
            String d =  doc.html();

            String date = doc.location();
            System.out.println(title);
            System.out.println(date);
            Element e = doc.body();
            System.out.println(e);
        }
        catch (Exception e){}

    }
}
