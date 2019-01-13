package j2c.controllers;

import j2c.daos.AnswerDao;
import j2c.pojos.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @Autowired
    AnswerDao ansDao;

    @GetMapping("/j2c/editAnswer")
    public String editAnswer(@RequestParam("answerId") Integer answerId, Model model) {
        Answer ans = ansDao.getAnswer(answerId);
            model.addAttribute("answer", ans);
            return "edit_answer";

    }

    @GetMapping("/j2c/editAnswerSubmit")
    public String editAnswerSubmit() {
        return "edit_answer_submit";
    }

}
