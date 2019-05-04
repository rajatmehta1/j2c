package j2c.pojos;

/**
 *
 */
public class Topic {
    private String topicName;
    private int topicId;
    private String topicLang;

    public Topic() {

    }

    public Topic(int topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public Topic(int topicId, String topicName, String topicLang) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicLang = topicLang;
    }

    public String getTopicName() {
        return topicName;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicLang() {
        return topicLang;
    }

    public void setTopicLang(String topicLang) {
        this.topicLang = topicLang;
    }
}
