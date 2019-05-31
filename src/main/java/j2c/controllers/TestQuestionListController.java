package j2c.controllers;

import j2c.daos.QuestionListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import j2c.pojos.Question;
import java.util.List;

public class TestQuestionListController {

    @Autowired
    QuestionListDao qdao;


    @RequestMapping(value="/j2c/testquestions", method = RequestMethod.GET)
    public @ResponseBody List<Question> getQuestions() {
        return qdao.findQuestionsByRange(0, true, "en");
    }


}
