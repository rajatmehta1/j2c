package j2c.controllers;

import j2c.pojos.Question;
import j2c.test.Customer;
import j2c.test.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    MyBean myBean;

    @GetMapping("/j2c/question/{id}")
    public String getQuestion(@PathVariable String id, Model model) {
        Customer c = new Customer();
        c.setAge(38);
        c.setName("harpreet");
        myBean.insert(c);
        Question q = new Question();
        q.setId(new Integer(id));
        q.setQsTxt("dummy text00");
        model.addAttribute("question",q);
        return "question";
    }
}
