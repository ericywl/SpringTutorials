package starter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Java", "Java Description"),
            new Topic("javascript", "Javascript", "Javascript Description")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    // lambda expression, go find out more at Java documentation
    public Topic getTopic(String id) {
        return topics.stream()
                .filter(topic -> topic.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic currTopic = topics.get(i);
            if (currTopic.getId().equals(topic.getId())) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }
}
