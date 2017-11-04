package tutorial.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepo;

    @Autowired
    public TopicService(TopicRepository topicRepo) {
        this.topicRepo = topicRepo;
    }

    public List<Topic> getAllTopics() {
        List<Topic> output = new ArrayList<>();
        topicRepo.findAll().forEach(output :: add);

        return output;
    }

    public Topic getTopic(String id) {
        return topicRepo.findOne(id);
    }

    public void addTopic(Topic topic) {
        topicRepo.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepo.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepo.delete(id);
    }
}
