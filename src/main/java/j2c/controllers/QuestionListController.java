package j2c.controllers;

import j2c.daos.QuestionListDao;
import j2c.pojos.*;
import j2c.utils.LangHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
/*
 * List of questions first page with topics
 */
@Controller
public class QuestionListController {

    @Autowired
    QuestionListDao qlDao;

    @Autowired
    Preferences pref;

    @RequestMapping("/j2c")
    public String getQuestionList(HttpServletRequest request, HttpServletResponse response, @RequestParam(name="lang") String lang, Model model) {
        if(null == lang)
            lang = "en";
      //  String localLang = LangHelper.langFromCookie(request, response, lang);
            pref.setLang(lang);
        List<Question> ql =
                qlDao.findQuestions( true, lang);
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
            model.addAttribute("srch",new Search());
        return "questionList";
    }

//OLD Deprecated.
//    @RequestMapping("/j2c")
//    public String getQuestionList(Model model) {
//        List<Question> ql =
//                qlDao.findQuestions(true);
////        for (Question q:ql
////             ) {
////            System.out.println(" ------> " + q.getQsTxt());
////
////        }
//        List<Topic> topics = qlDao.findTopics();
//        model.addAttribute("questions", ql);
//        model.addAttribute("qst",new Question());
//        model.addAttribute("ans",new Answer());
//        model.addAttribute("usr",new User());
//        model.addAttribute("topics",topics);
//        return "questionList";
//    }

    @RequestMapping("/j2c/topic/{topicId}/questionsList")
    public String getQuestionList(@PathVariable int topicId, Model model) {
        List<Question> ql =
                qlDao.findQuestions( topicId,true, pref.getLang());
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
        model.addAttribute("srch",new Search());
        return "questionList";
    }





}
