package j2c.utils.extract;

import j2c.pojos.Answer;
import j2c.pojos.Question;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class QuestionExtractor {

    public Question getQuestionFromQuora(String qurl) throws Exception {
        Document doc = Jsoup.connect(qurl).get();
        return null;
    }

    public static void main(String[] args) {

    }

    public Question getQuestion(String q) {
        Question question = new Question();
            question.setQsTxt(q);
            return question;
    }

    public Answer getAnswer(String atxt) {
        Answer ans = new Answer();
            ans.setAnsTxt(atxt);
            return ans;
    }

}
