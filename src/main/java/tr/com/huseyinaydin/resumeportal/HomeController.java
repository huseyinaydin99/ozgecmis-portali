package tr.com.huseyinaydin.resumeportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.huseyinaydin.resumeportal.models.UserProfile;

import java.security.Principal;
import java.util.Optional;

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

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUserName(userId);
        userProfile.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı hacım: " + userId));

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile.get());

        return "profile-templates/" + userProfile.get().getId() + "/index";
    }
}