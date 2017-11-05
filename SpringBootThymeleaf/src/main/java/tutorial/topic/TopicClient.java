package tutorial.topic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class TopicClient {
    @GetMapping("/topics")
    public String listAllTopics(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String getUrl = "http://localhost:5000/topics";
        List<Topic> topicList = restTemplate.getForObject(getUrl, List.class);

        model.addAttribute("topics", topicList);

        return "topics";
    }
}
