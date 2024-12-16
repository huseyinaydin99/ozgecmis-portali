package tr.com.huseyinaydin.resumeportal;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.huseyinaydin.resumeportal.models.User;

import java.util.Optional;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot
 *
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}