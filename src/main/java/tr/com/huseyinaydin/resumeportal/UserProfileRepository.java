package tr.com.huseyinaydin.resumeportal;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.huseyinaydin.resumeportal.models.UserProfile;

import java.util.Optional;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot
 *
 */

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUserName(String userName);
}