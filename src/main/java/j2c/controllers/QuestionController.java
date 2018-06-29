package j2c.controllers;

import j2c.pojos.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class QuestionController {


    @GetMapping("/j2c/question/{id}")
    public String getQuestion(@PathVariable String id, Model model) {
        Question q = new Question();
            q.setId(new Integer(id));
            q.setQsTxt("dummy text00");
            model.addAttribute("question",q);
            return "question";
    }
}
