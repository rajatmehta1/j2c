package j2c.controllers;

import com.google.gson.Gson;
import j2c.daos.QuestionDao;
import j2c.daos.QuestionListDao;
import j2c.pojos.Question;
import j2c.utils.insert.IndexDocuments;
import j2c.utils.search.SearchDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    QuestionListDao qdao;

    @Autowired
    QuestionDao questionDao;

    @RequestMapping("/j2c/qjson")
    public @ResponseBody String getQuestions() {
        List<Question> questions = qdao.findQuestionsByRange(0,false);
        Gson gson = new Gson();
        return gson.toJson(questions);
    }

    @RequestMapping("/j2c/startIndexing")
    public @ResponseBody String startIndexing() throws Exception {
        Question q = questionDao.findQuestion(9, true);
        Gson gson = new Gson();
        String jsonObj = gson.toJson(q);
        IndexDocuments id = new IndexDocuments();
            id.indexDoc(jsonObj);
            return jsonObj;
    }

    @RequestMapping("/j2c/search")
    public @ResponseBody ArrayList<Question> search(@RequestParam(name = "srch") String srchTxt) throws Exception {
        ArrayList<Question> rst = SearchDocuments.searchDocument(srchTxt);
        return rst;
    }


}
