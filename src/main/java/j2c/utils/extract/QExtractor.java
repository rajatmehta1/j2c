package j2c.utils.extract;

import j2c.pojos.Question;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;

public class QExtractor {
//    private static final String URL_START = "https://www.quora.com";
//
//    public static ArrayList<String> getBulkUrlsFromQuora(String qurl) throws Exception {
//        ArrayList<String> urlList = new ArrayList<>();
//        String webloc = "https://www.quora.com/search?q=diabetes+india";
//        Document doc = Jsoup.connect(webloc).get();
//        Elements qlist = doc.select("a.question_link");
//        for(Element questionElem: qlist) {
//            System.out.println("\n ---------------------------------------- \n");
//            System.out.println(questionElem.attr("href"));
//            System.out.println("\n ---------------------------------------- \n");
//                urlList.add(URL_START + questionElem.attr("href"));
//        }
//        return urlList;
//    }
//
//    public static Question getQuestionFromQuora(String qurl) throws Exception {
//        Document doc= Jsoup.connect(qurl).get();
//        Elements qlist = doc.select("span.ui_qtext_rendered_qtext");
//        Element question = qlist.get(0);
//        System.out.println("Title of the page is : -  +
//we    }
}
