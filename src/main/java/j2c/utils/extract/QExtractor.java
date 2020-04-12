package j2c.utils.extract;

import j2c.pojos.Answer;
import j2c.pojos.Question;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//main class
public class QExtractor {

    private static final String URL_START =
            "https://www.quora.com";

    public static ArrayList<String> getBulkUrlsFromQuora(String qurl) throws Exception {
        ArrayList<String> urlList = new ArrayList<>();
       // String webloc = "https://www.quora.com/search?q=cancer+india"; //replace the below custom url for local testing
        String webloc = qurl;
        Document doc = Jsoup.connect(webloc).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get();
        Elements qlist = doc.select("a.question_link");
        for (Element questionElem : qlist) {
//            System.out.println("\n ---------------------------------------- \n");
//            System.out.println(questionElem.attr("href"));
//            System.out.println("\n ---------------------------------------- \n");
            urlList.add(URL_START + questionElem.attr("href"));
        }
        return urlList;
    }

    public static Question getQuestionsFromQuora(String qurl) throws Exception {
        System.out.println("Came here 0");
        Document doc = Jsoup.connect(qurl).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get();
        System.out.println("Came here 1");
        Elements qlist =
                doc.select("span.ui_qtext_rendered_qtext");
        System.out.println("Came here 2");
        Element question = qlist.get(0);
//        System.out.println("Title of the page is :-" + question.childNode(0).toString());
        Question q = getQuestion(question.childNode(0).toString());
        System.out.println("Came here 3");
        Elements allAnswersList = doc.select("div.layout_2col_main");
        Element allAnswers = allAnswersList.get(0);
        System.out.println("Came here 4");
        Elements answers = allAnswers.select("div.ui_qtext_expanded");
        ArrayList<Answer> ansList = new ArrayList<>();

        for (Element answer : answers) {
            if(answer.text().length() < 5000) {
                ansList.add(getAnswer(answer.text()));
                System.out.println("\n\n-------------------------\n\n");
                System.out.println(answer.text());
//            System.out.println("\n\n------------------------------------\n\n");
            }
        }
        q.setAnsList(ansList);
//        System.out.println(allAnswers.html());
        return q;
    }


    public static Question getQuestion(String qtxt) {
        Question q = new Question();
            q.setQsTxt(qtxt);
            return q;
    }

    public static Answer getAnswer(String a) {
        Answer ans = new Answer();
            ans.setAnsTxt(a);
            return ans;
    }

    public static void main(String[] args) throws Exception {
        String webloc = "http://www.quora.com/What-is-the-best-way-to-manage-type-2-diabetes-by-Indian-Diet";
        Question q = getQuestionsFromQuora(webloc);
        System.out.println("Title of the page is ---> " + q.getQsTxt());
//
//        List<Answer> ansList = q.getAnsList();
//        for(Answer a: ansList) {
//            System.out.println(" ----------> " + a.getAnsTxt());
//        }

//        Document doc = Jsoup.connect(webloc).get();
//        Elements qlist = doc.select("span.ui_qtext_rendered_qtext");
//        Element question = qlist.get(0);
//        System.out.println("Title of the page is ---> " + question.childNode(0).toString());
//
//        Question q = getQuestionsFromQuora(question.childNode(0).toString());
//        Elements allAnswersList = doc.select("div.answer_text_small");
//        Element allAnswers = allAnswersList.get(0);
//        Elements answers = allAnswers.select("div.u-serid-font-main--large");
//        ArrayList<Answer> ansList = new ArrayList<>();
//        for (Element answer : answers) {
//            ansList.add(getAnswer(answer.html()));
//            System.out.println("\n\n-------------------------\n\n");
//            System.out.println(answer.html());
//            System.out.println("\n\n------------------------------------\n\n");
//        }
//        q.setAnsList(ansList);
//        System.out.println(allAnswers.html());
    }
}
