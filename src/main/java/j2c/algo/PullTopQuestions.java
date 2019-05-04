package j2c.algo;

import j2c.daos.QuestionDao;
import j2c.daos.TopicsDao;
import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.Topic;
import j2c.utils.extract.QExtractor;
import j2c.utils.lang.LangConverter;
import j2c.utils.translate.TranslateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 1. Fetch topics
 * 2. Build search question
 * 3. Extract questions ----> build checksum
 * 4. Remove duplicates
 * 5. PUll question and answers
 * 6. Convert to different languages and insert
 */
@Component
public class PullTopQuestions {

    @Autowired
    private TopicsDao topicsDao;

    @Autowired
    private QuestionDao questionDao;

    private List<Topic> topics;

    private List<String> otherLangs;


     public PullTopQuestions() {
         otherLangs = new ArrayList<>();
         otherLangs.add("hi");otherLangs.add("te");
     }

     /*
      * Main method handling the core operation
      */
     public void run() {
         List<Topic> topicList = fetchTopics();

         for (Topic t: topicList) {
             ArrayList<String> trendingQuestionUrlsForTopic = trendingQuestionsForTopic(t);
             ArrayList<Question> questions = fetchQuestionFromQuesUrls(trendingQuestionUrlsForTopic);
                insertToDB(questions, "en"); // english
                convertAndInsert(questions);//convert to lang list
         }

     }

    public void testRun(boolean insertInDB) {
        Topic tt = new Topic();
            tt.setTopicName("diabetes");

        List<Topic> topicList = Arrays.asList(tt);

        for (Topic t: topicList) {
            ArrayList<String> trendingQuestionUrlsForTopic = trendingQuestionsForTopic(t);
            ArrayList<Question> questions = fetchQuestionFromQuesUrls(trendingQuestionUrlsForTopic);
            for(Question q:questions) {
                System.out.print("question --> " + q.getQsTxt());
            }

            ArrayList<Question> hiQuestions = this.convertQuestions(questions, "hi");

            for(Question q:hiQuestions) {
                System.out.print("hiQuestion --> " + q.getQsTxt());
            }

            if(insertInDB) {
                 insertToDB(questions, "en"); // english
                 convertAndInsert(questions);//convert to lang list
            }
        }

    }




    public List<Topic> fetchTopics() {
         if(null == topics)
             topics = topicsDao.findTopics();
         return topics;
     }

     // Try pagination in this...store the old paginated number and next pull from next number onwards
     public ArrayList<String> trendingQuestionsForTopic(Topic t) {
         String bulkQuestionsUrl = "https://www.quora.com/search?q=" + t.getTopicName() + "+india";
         ArrayList<String> bulkQuestionUrls = null;
         try {
             bulkQuestionUrls =
                     QExtractor.getBulkUrlsFromQuora(bulkQuestionsUrl);
         } catch(Exception e) {
             e.printStackTrace();
         }
         return bulkQuestionUrls;
     }

    private ArrayList<Question> fetchQuestionFromQuesUrls(ArrayList<String> trendingQuestionUrlsForTopic) {
         ArrayList<Question> questions = new ArrayList<>();
        for (String qurl: trendingQuestionUrlsForTopic) {
            try {
                Question q = QExtractor.getQuestionsFromQuora(qurl);
                    questions.add(q);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return questions;
    }

     public ArrayList<Question> extractQuestionsWithAnswers() {
         return null;
     }



     public void insertToDB(ArrayList<Question> qList,String lang) {

         for (Question q: qList) {
            int qid = questionDao.insertWithKey(q, lang);
                q.setId(qid);

                if(null != q.getAnsList()) {
                    for (Answer ans : q.getAnsList()) {
                        ans.setQuestionId(qid);
                        questionDao.insertAnswer(ans, lang);
                    }
                }
         }

     }
    private String convertAndInsert(ArrayList<Question> questions) {
         String toLang = "hi";
         ArrayList<Question> cq = this.convertQuestions(questions, toLang);
         this.insertToDB(cq,toLang);
         return "completed conversion and insert";
    }
    private ArrayList<Question> convertQuestions(ArrayList<Question> questions, String toLang) {
         ArrayList<Question> cqs = new ArrayList<>();
         Question q = null;
        //first testing with one question
        try {
            q = TranslateHelper.translate("en", toLang, questions.get(0)); // only the first question
        }catch(Exception e) {
            e.printStackTrace();
        }
        return cqs;
    }


    public static void main(String[] args) throws Exception {
        PullTopQuestions pt = new PullTopQuestions();
        //String result = lc.convertText("en","hi","this is a test message");
        //System.out.println("result : " + result);
        pt.testRun(true); // INSERT TO DB will not run as Spring is not initiallied here
    }


}
