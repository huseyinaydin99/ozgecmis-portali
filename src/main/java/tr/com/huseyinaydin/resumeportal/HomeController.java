package tr.com.huseyinaydin.resumeportal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot
 *
 */

@Controller
public class HomeController {

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        model.addAttribute("userId", userId);
        return "profile-templates/1/index";
    }
}