package j2c.utils.extract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BulkExtractor {
    public static void main(String[] args) throws Exception {
        String webloc = "https://www.quora.com/search?q=diabetes+india";
        Document doc = Jsoup.connect(webloc).proxy("proxy.jpmchase.net",8443).get();
        Elements qlist = doc.select("a.question_link");
        for(Element questionElem: qlist) {
            System.out.println("\n--------------------------------------\n");
            System.out.println(questionElem.attr("href"));
            System.out.println("\n--------------------------------------\n");
        }
    }
}
