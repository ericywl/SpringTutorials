package tutorial.topic;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TopicClient {
//    @GetMapping("/topics")
//    public String listAllTopics(Model model) {
//        // consumes REST from FirstSpringBootDatabase
//        RestTemplate restTemplate = new RestTemplate();
//        String getUrl = "http://localhost:5000/topics";
//
//        // parse JSON to List<Topic>
//        ResponseEntity<List<Topic>> topicsResponse = restTemplate.exchange(getUrl, HttpMethod.GET,
//                null, new ParameterizedTypeReference<List<Topic>>() {});
//
//        List<Topic> topicList = topicsResponse.getBody();
//        model.addAttribute("topics", topicList);
//
//        return "topics";
//    }

    @GetMapping("/topics")
    String showTopicList(Model model) {
        TopicList topicList = new TopicList();
        topicList.addTopic(new Topic("python", "Python", "Python description"));
        topicList.addTopic(new Topic("java", "Java", "Java description"));

        model.addAttribute("topics", topicList);
        return "topics :: resultsList";
    }

    @GetMapping("/topics/{id}")
    String showTopic(Model model, @PathVariable String id) {
        TopicList topicList = new TopicList();
        topicList.addTopic(new Topic("python", "Python", "Python description"));
        topicList.addTopic(new Topic("java", "Java", "Java description"));

        model.addAttribute("topics", topicList.getTopic(id));
        return "topics :: resultsList";
    }
}
