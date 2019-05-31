package j2c.controllers;

import j2c.daos.QuestionDao;
import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.User;
import j2c.test.Customer;
import j2c.test.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    QuestionDao qdao;

    @Autowired
    Preferences pref;


    @RequestMapping(value="/j2c/question/{id}",method= RequestMethod.GET)
    public String getQuestion(@PathVariable String id, Model model) {

        int qid = Integer.parseInt(id);
        Question q = qdao.findQuestion(qid,true, pref.getLang());
        model.addAttribute("question",q);
        model.addAttribute("qst",new Question());
        model.addAttribute("ans",new Answer());
        model.addAttribute("usr",new User());
            return "question";

    }


    @RequestMapping(value="/j2c/addQuestion",method=RequestMethod.POST)
    public String addQuestion(@ModelAttribute("qst") Question qst, Model model) {
        //qst.setTopicId(2);
        qst.setCreatedBy(2);
        int k = qdao.insertWithKey(qst, pref.getLang());
        return getQuestion("" + k, model);

    }


    @RequestMapping(value="/j2c/addAnswer",method=RequestMethod.POST)
    public String addAnswer(@ModelAttribute("ans") Answer ans) {
        //qst.setTopicId(2);
        ans.setCreatedBy(2);
        qdao.insertAnswer(ans, pref.getLang());
        return "result";
    }

}
