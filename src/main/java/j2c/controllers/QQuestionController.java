package j2c.controllers;

import j2c.daos.QuestionDao;
import j2c.daos.QuestionListDao;
import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.User;
import j2c.utils.extract.QExtractor;
import j2c.pojos.QuestionExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class QQuestionController {

    @Autowired
    public QuestionDao qdao;

    @Autowired
    public QuestionListDao qlistDao;


    @RequestMapping("")
    public void showExtractLink() {

    }

    //Extracting data from one URL
    @RequestMapping(value = "/j2c/qextract",method = RequestMethod.GET)
    public String showExtractLink(Model model) {
        model.addAttribute("qex", new QuestionExtractor());
        model.addAttribute("qst",new Question());
        model.addAttribute("ans", new Answer());
        model.addAttribute("usr",new User());
        return "qe";
    }

    @RequestMapping(value = "/j2c/qebulk", method=RequestMethod.GET)
    public String showExtractBulkLink(Model model) {
        model.addAttribute("qex", new QuestionExtractor());
        model.addAttribute("qst",new Question());
        model.addAttribute("ans", new Answer());
        model.addAttribute("usr",new User());
        return "qe_bulk";
    }

    @RequestMapping(value = "/j2c/addQuestionExternal", method=RequestMethod.POST)
    public String addQuestion(@ModelAttribute("qex") QuestionExtractor qst, Model model) throws Exception {
        Question q = QExtractor.getQuestionsFromQuora(qst.getQuestionUrl());
            q.setTopicId(1); //TODO
            q.setCreatedBy(2); //TODO
        int qid = qdao.insertWithKey(q);

        for(Answer ans: q.getAnsList()) {
            ans.setQuestionId(qid);
            ans.setCreatedBy(1);//TODO
            qdao.insertAnswer(ans);
        }

        return showExtractLink(model);
    }


    @RequestMapping(value = "/j2c/addBulkExternal", method=RequestMethod.POST)
    public String addBulkQuestion(@ModelAttribute("qex") QuestionExtractor qst, Model model) throws Exception {
        ArrayList<String> qsMap = QExtractor.getBulkUrlsFromQuora(qst.getQuestionUrl());
        //TODO
        for(String qkey: qsMap) {
            Question q = QExtractor.getQuestionsFromQuora(qkey);
            q.setTopicId(1); //TODO
            q.setCreatedBy(2); //TODO
            int qid = qdao.insertWithKey(q);

            for(Answer ans: q.getAnsList()) {
                ans.setQuestionId(qid);
                ans.setCreatedBy(2);//TODO
                qdao.insertAnswer(ans);
            }



        }
        return showExtractLink(model);
    }


    @RequestMapping("/j2c/storeQuestions")
    public @ResponseBody String storeQuestionsInMap() {
        qlistDao.getAllQuestions();
        return "Stored in Cache";
    }

//
//    @RequestMapping(value="/j2c/addBulkExternal", method = RequestMethod.POST)
//    public String addBulkQuestions(@ModelAttribute("qex") QuestionExtractor qst, Model model) throws Exception {
//        HashMap<String, String> qsMap = qlistDao.getAllQuestions();
//        Question q = QExtractor.getQuestionsFromQuora(qst.getQuestionUrl());
//            q.setTopicId(1);
//            q.setCreatedBy(2);
//            int qid = qdao.insertWithKey(q);
//
//            for(Answer ans : q.getAnsList()) {
//                ans.setQuestionId(qid);
//                ans.setCreatedBy(2);
//                qdao.insertAnswer(ans);
//            }
//            return showExtractLink(model);
//
//    }


    //working store builk questions method.
    @RequestMapping("/j2c/bulkExtractQuestions")
    public @ResponseBody String storeBulkQuestions() throws Exception {
        ArrayList<String> urlList = QExtractor.getBulkUrlsFromQuora("https://www.quora.com/search?q=diabetes+india");

        int sz = (urlList.size() > 1) ? urlList.size() - 1: 0;
        for(int i = 0 ; i < sz ;i++) {
            Question q = QExtractor.getQuestionsFromQuora(urlList.get(i));
                q.setTopicId(1);
                q.setCreatedBy(2);
                q.setQlink(urlList.get(i));
                int qid = qdao.insertWithKey(q);

                for(Answer ans: q.getAnsList() ) {
                    ans.setQuestionId(qid);
                    ans.setCreatedBy(2);
                    qdao.insertAnswer(ans);
                }
        }
        return "Created "+ sz +" questions";
    }

}
