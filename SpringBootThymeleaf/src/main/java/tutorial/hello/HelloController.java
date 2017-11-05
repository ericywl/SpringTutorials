package tutorial.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {
    @Value("${hello.message}")
    private String message = "Hello World!";

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Map<String, Object> model) {
        model.put("message", this.message);
        return "hello";
    }
}
