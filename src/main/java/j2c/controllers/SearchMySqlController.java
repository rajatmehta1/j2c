package j2c.controllers;

import j2c.daos.QuestionListDao;
import j2c.pojos.*;
import j2c.utils.search.SearchDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller class to search in Mysql
 * /m/ --> points to mysql
 *
 * @version 1.0
 */
@Controller
public class SearchMySqlController {

    @Autowired
    QuestionListDao qlDao;

    @RequestMapping("/j2c/m/search")
    public @ResponseBody List<Question> search(@RequestParam(name = "srch") String srchTxt) throws Exception {
        List<Question> rst = qlDao.searchQuestions(srchTxt,true);
        return rst;
    }


    @RequestMapping(value="/j2c/m/srch",method= RequestMethod.POST)
    public String search(@ModelAttribute("srch") Search srchAttr, Model model) {
        List<Question> rst = qlDao.searchQuestions(srchAttr.getSrchTxt(),true);
            model.addAttribute("srch_results",rst);

        List<Topic> topics = qlDao.findTopics();
            model.addAttribute("questions", rst);
            model.addAttribute("qst",new Question());
            model.addAttribute("ans",new Answer());
            model.addAttribute("usr",new User());
            model.addAttribute("topics",topics);
            model.addAttribute("srch",new Search());

        return "search_result";
    }


}
