package j2c.pojos;

public class Topic {
    private String topicName;
    private int topicId;
    private String topicLang;

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
}
