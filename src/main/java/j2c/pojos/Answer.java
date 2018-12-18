package j2c.pojos;

public class Answer {
    private Integer id;
    private String ansTxt = "Enter your reply here ...";
    private int order;
    private Integer questionId;
    private Integer createdBy;

    public Answer() {

    }

    public Answer(int aid, String a_text, int created_by) {
        this.id = aid;
        this.ansTxt = a_text;
        this.createdBy = created_by;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnsTxt() {
        return ansTxt;
    }

    public void setAnsTxt(String ansTxt) {
        this.ansTxt = ansTxt;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
}
