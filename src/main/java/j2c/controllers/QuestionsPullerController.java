package j2c.controllers;

import j2c.algo.PullTopQuestions;
import j2c.pojos.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/j2c")
public class QuestionsPullerController {

    @Autowired
    public PullTopQuestions topQstHelper;


    @GetMapping("/tq")
    public @ResponseBody String pullTopQuestions() {
        topQstHelper.run();
        return "Pulled questions check in DB";
    }


}
