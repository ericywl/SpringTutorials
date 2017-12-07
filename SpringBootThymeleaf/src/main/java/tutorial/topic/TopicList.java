package tutorial.topic;

import java.util.ArrayList;
import java.util.List;

public class TopicList {
    private List<Topic> topicList = new ArrayList<>();

    public void addTopic(Topic topic) {
        topicList.add(topic);
    }

    public Topic getTopic(String id) {
        for (Topic topic : topicList) {
            if (topic.getId().equals(id))
                return topic;
        }

        return null;
    }
}
