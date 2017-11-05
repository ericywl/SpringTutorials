package tutorial.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(HelloForm helloForm) {
        return "index";
    }

    @PostMapping("/")
    public String validate(@Valid HelloForm helloForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        model.addAttribute("name", helloForm.getName());
        return "redirect:/topics";
    }
}
