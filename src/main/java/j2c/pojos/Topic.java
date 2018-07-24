package j2c.pojos;

public class Topic {
    private String topicName;
    private int topicId;

    public Topic(int topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public int getTopicId() {
        return topicId;
    }
}
