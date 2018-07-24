package j2c.controllers;

import j2c.daos.QuestionListDao;
import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.Topic;
import j2c.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/*
 * List of questions first page with topics
 */
@Controller
public class QuestionListController {

    @Autowired
    QuestionListDao qlDao;



    @RequestMapping("/j2c")
    public String getQuestionList(Model model) {
        List<Question> ql =
                qlDao.findQuestions(true);
//        for (Question q:ql
//             ) {
//            System.out.println(" ------> " + q.getQsTxt());
//
//        }
        List<Topic> topics = qlDao.findTopics();
        model.addAttribute("questions", ql);
        model.addAttribute("qst",new Question());
        model.addAttribute("ans",new Answer());
        model.addAttribute("usr",new User());
        model.addAttribute("topics",topics);
        return "questionList";
    }

    @RequestMapping("/j2c/topic/{topicId}/questionsList")
    public String getQuestionList(@PathVariable int topicId, Model model) {
        List<Question> ql =
                qlDao.findQuestions( topicId,true);
//        for (Question q:ql
//             ) {
//            System.out.println(" ------> " + q.getQsTxt());
//
//        }
        List<Topic> topics = qlDao.findTopics();
        model.addAttribute("questions", ql);
        model.addAttribute("qst",new Question());
        model.addAttribute("ans",new Answer());
        model.addAttribute("usr",new User());
        model.addAttribute("topics",topics);
        return "questionList";
    }



}
