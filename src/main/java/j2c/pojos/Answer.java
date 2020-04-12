package j2c.pojos;

public class Answer {
    private Integer id;
    private String ansTxt = "Enter your reply here ...";
    private int order;
    private Integer questionId;
    private Integer createdBy;
    private String shortAnsText;

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

    //truncate to fit on main screen to 400 characters
    public String getShortAnsText() {
//        if(ansTxt.length() > 400) return ansTxt.substring(0,400);
//        else return ansTxt;
        return ansTxt;
    }

    public void setShortAnsText(String st) {
        shortAnsText = st;
    }
}
