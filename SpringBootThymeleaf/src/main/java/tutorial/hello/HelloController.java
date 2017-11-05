package tutorial.hello;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(HelloForm helloForm) {
        return "index";
    }

    @PostMapping("/")
    public String validate(@Valid HelloForm helloForm, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        // validates helloForm
        if (bindingResult.hasErrors()) {
            return "index";
        }

        // redirect "name" to topics for display
        redirectAttributes.addFlashAttribute("name", helloForm.getName());
        return "redirect:/topics";
    }
}
