package j2c.batch.etl.jobs.langconvert;

import j2c.daos.QuestionListDao;
import j2c.pojos.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/*
 * Pull multiple questions in trending categories and
 * convert to different languages and store in db
 */
@Component
public class QuestionsPuller {

    @Autowired
    QuestionListDao qLstDao;

    public QuestionsPuller() {
    }

    //Run in Daemon or store in some queue
    public String storeQuestions() {
        List<Topic> topics = qLstDao.findTopics();
        List<String> urls = new ArrayList<>();
        for (Topic topic: topics) {

        }
        return null;
    }


    public String buildSrchUrl() {
        return null;
    }

}
