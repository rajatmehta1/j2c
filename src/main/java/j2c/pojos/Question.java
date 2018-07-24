package j2c.pojos;

import java.util.List;

public class Question {

    private Integer id;
    private String qsTxt;
    private Integer topicId;
    private List<Answer> ansList;
    private List<Comment> cmtList;
    private List<Question> relQList;
    private Integer createdBy;
    private Answer firstAnswer;

    public Question() {

    }

    public Question(int qid, String q_text, int topic_id, int created_by) {
        this.id = qid;
        this.qsTxt = q_text;
        this.topicId = topic_id;
        this.createdBy = created_by;
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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Answer getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(Answer firstAnswer) {
        this.firstAnswer = firstAnswer;
    }
}
