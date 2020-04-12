package j2c.algo;

import j2c.daos.QuestionDao;
import j2c.daos.QuestionListDao;
import j2c.daos.TopicsDao;
import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.Topic;
import j2c.utils.extract.QExtractor;
import j2c.utils.lang.LangConverter;
import j2c.utils.translate.TranslateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

    @Autowired
    private QuestionListDao qlDao;

    private List<Topic> topics;

    private List<String> otherLangs;

    private LangConverter lc = new LangConverter();

    private HashMap<String,String> eqMap = new HashMap<>();

     public PullTopQuestions() {
         otherLangs = new ArrayList<>();
         otherLangs.add("hi");otherLangs.add("te");
     }

     public void init() {
         qlDao.populateQuestionsMap(eqMap);
     }

     /*
      * Main method handling the core operation
      */
//     @Async
     public void run() {
       //  this.init();
//        List<Topic> topicList = fetchTopics();


         Topic tt = new Topic();
         tt.setTopicName("Asthma");
         tt.setTopicId(17);

         List<Topic> topicList = Arrays.asList(tt);


         for (Topic t: topicList) {
             ArrayList<String> trendingQuestionUrlsForTopic = trendingQuestionsForTopic(t);
             ArrayList<Question> questions = fetchQuestionFromQuesUrls(trendingQuestionUrlsForTopic);
                insertToDB(questions, "en",t.getTopicId()); // english
                convertAndInsert(questions,t.getTopicId());//convert to lang list
         }

         System.out.println("##################The load of questions is completed ############################");
     }

    public void testRun(boolean insertInDB) {
        Topic tt = new Topic();
            tt.setTopicName("diabetes");
            tt.setTopicId(1);

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
                 insertToDB(questions, "en",t.getTopicId()); // english
                 convertAndInsert(questions,t.getTopicId());//convert to lang list
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
         String bulkQuestionsUrl = "https://www.quora.com/search?q=corona";
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
         int i = 0;
        for (String qurl: trendingQuestionUrlsForTopic) {
            try {
                Question q = QExtractor.getQuestionsFromQuora(qurl);
                    questions.add(q);
            } catch(Exception e) {
                e.printStackTrace();
            }
            if (i == 0) break;
        }
        return questions;
    }

     public ArrayList<Question> extractQuestionsWithAnswers() {
         return null;
     }



     public void insertToDB(ArrayList<Question> qList,String lang,int topicId) {

         for (Question q: qList) {
             q.setTopicId(topicId);
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
    private String convertAndInsert(ArrayList<Question> questions,int topicId) {
         String toLang = "hi";
         ArrayList<Question> cq = this.convertQuestions(questions, toLang);
         this.insertToDB(cq,toLang,topicId);
         return "completed conversion and insert";
    }
    private ArrayList<Question> convertQuestions(ArrayList<Question> questions, String toLang) {
         ArrayList<Question> cqs = new ArrayList<>();
         Question q = null;
        //first testing with one question
        try {
          //  q = TranslateHelper.translate("en", toLang, questions.get(0)); // only the first question
            String rst = null;
            for(Question qst: questions) {
                 rst = lc.convertText("en", toLang, qst.getQsTxt()); // only the first question
                 q = qst;
                 q.setQsTxt(rst);

                 if(null != q.getAnsList() && q.getAnsList().size() > 0) {
                     Answer ans = q.getAnsList().get(0);
                     String ansTxt = lc.convertText("en", toLang, ans.getAnsTxt());
                        ans.setAnsTxt(ansTxt);
                     ArrayList<Answer> alist = new ArrayList<>();
                        alist.add(ans);
                        q.setAnsList(alist);
                 }

                 cqs.add(q);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return cqs;
    }


    public static void main(String[] args) throws Exception {
        PullTopQuestions pt = new PullTopQuestions();
        //String result = lc.convertText("en","hi","this is a test message");
        //System.out.println("result : " + result);
        pt.testRun(false); // INSERT TO DB will not run as Spring is not initiallied here
    }


}
