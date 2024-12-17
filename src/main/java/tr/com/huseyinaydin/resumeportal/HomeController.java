package tr.com.huseyinaydin.resumeportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tr.com.huseyinaydin.resumeportal.models.Education;
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
        /*UserProfile profile = new UserProfile();
        profile.setId(1);
        profile.setUserName("huseyinaydin99");
        profile.setDesignation("Atama");
        profile.setFirstName("Hüseyin");
        profile.setLastName("Aydın");
        profile.setTheme(1);*/
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName("huseyinaydin99");
        UserProfile profile = userProfileOptional.get();

        Job job = new Job();
        job.setCompany("Şirket 1");
        job.setDesignation("Atama");
        job.setId(1);
        job.setStartDate(LocalDate.of(2024, 1, 1));
        //job.setEndDate(LocalDate.of(2025,1,1));
        job.setCurrentJob(true);
        job.getResponsibilities().add("Spring Framework");
        job.getResponsibilities().add("Spring Boot");
        job.getResponsibilities().add("Hibernate");

        Job job2 = new Job();
        job2.setCompany("Şirket 2");
        job2.setDesignation("Atama");
        job2.setId(2);
        job2.setStartDate(LocalDate.of(2022, 1, 1));
        job2.setEndDate(LocalDate.of(2026,1,1));
        job.getResponsibilities().add(".NET Framework");
        job.getResponsibilities().add(".NET Core");
        job.getResponsibilities().add("Dapper");

        Education e1 = new Education();
        e1.setCollege("Bor MYO");
        e1.setQualification("Ön lisans");
        e1.setSummary("Çok çalıştım çoook");
        e1.setStartDate(LocalDate.of(2012, 5, 1));
        e1.setEndDate(LocalDate.of(2014, 1, 1));

        Education e2 = new Education();
        e2.setCollege("Hayat Üniversitesi");
        e2.setQualification("Üst seviye");
        e2.setSummary("Acı geliştirir insanı.");
        e2.setStartDate(LocalDate.of(2014, 5, 1));
        e2.setEndDate(LocalDate.of(2024, 1, 1));

        profile.getEducations().clear();
        profile.getEducations().add(e1);
        profile.getEducations().add(e2);
        profile.getSkills().clear();
        profile.getSkills().add("Java");
        profile.getSkills().add("Spring Framework");
        profile.getSkills().add("SQL");
        profile.getSkills().add("JPA/Hibernate");

        //profile.setJobs(Arrays.asList(job, job2));
        profile.getJobs().clear();
        profile.getJobs().addAll(Arrays.asList(job, job2));

        userProfileRepository.save(profile);
        return "profile";
    }

    @GetMapping("/edit")
    public String edit(Model model, Principal principal) {
        String userId = principal.getName();
        model.addAttribute("userId", userId);
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı nacim: " + userId));
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        return "profile-edit";
    }

    @PostMapping("/edit")
    public String postEdit(Model model, Principal principal, @ModelAttribute UserProfile userProfile) {
        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userName);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı hacım: " + userName));
        UserProfile savedUserProfile = userProfileOptional.get();
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(userName);
        userProfileRepository.save(userProfile);
        return "redirect:/view/" + userName;
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model) {
        Optional<UserProfile> userProfile = userProfileRepository.findByUserName(userId);
        userProfile.orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı bacım: " + userId));

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile.get());

        return "profile-templates/" + userProfile.get().getTheme() + "/index";
    }
}