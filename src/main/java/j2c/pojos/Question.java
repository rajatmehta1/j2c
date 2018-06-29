package j2c.pojos;

import java.util.List;

public class Question {

    private Integer id;
    private String qsTxt;
    private List<Answer> ansList;
    private List<Comment> cmtList;
    private List<Question> relQList;

    public Question() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQsTxt() {
        return qsTxt;
    }

    public void setQsTxt(String qsTxt) {
        this.qsTxt = qsTxt;
    }

    public List<Answer> getAnsList() {
        return ansList;
    }

    public void setAnsList(List<Answer> ansList) {
        this.ansList = ansList;
    }

    public List<Comment> getCmtList() {
        return cmtList;
    }

    public void setCmtList(List<Comment> cmtList) {
        this.cmtList = cmtList;
    }

    public List<Question> getRelQList() {
        return relQList;
    }

    public void setRelQList(List<Question> relQList) {
        this.relQList = relQList;
    }
}
