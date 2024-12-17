package tr.com.huseyinaydin.resumeportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.huseyinaydin.resumeportal.models.Job;
import tr.com.huseyinaydin.resumeportal.models.UserProfile;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;
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

    @GetMapping("/")
    public String home() {
        UserProfile profile = new UserProfile();
        profile.setId(1);
        profile.setUserName("huseyinaydin99");
        profile.setDesignation("Atama");
        profile.setFirstName("Hüseyin");
        profile.setLastName("Aydın");
        profile.setTheme(1);

        Job job = new Job();
        job.setCompany("Şirket 1");
        job.setDesignation("Atama");
        job.setId(1);
        job.setStartDate(LocalDate.of(2024, 1, 1));
        job.setEndDate(LocalDate.of(2025,1,1));

        Job job2 = new Job();
        job2.setCompany("Şirket 2");
        job2.setDesignation("Atama");
        job2.setId(2);
        job2.setStartDate(LocalDate.of(2022, 1, 1));
        job2.setEndDate(LocalDate.of(2026,1,1));

        profile.setJobs(Arrays.asList(job, job2));
        return "profile";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUserName(userId);
        userProfile.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı hacım: " + userId));

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile.get());

        return "profile-templates/" + userProfile.get().getId() + "/index";
    }
}