package tr.com.huseyinaydin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tr.com.huseyinaydin.resumeportal.UserRepository;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot
 *
 */

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
/*
@EnableJpaRepositories(basePackageClasses = UserRepository.class) dipnotu, belirtilen sınıfın bulunduğu paketteki
(veya alt paketlerdeki) JPA repository arayüzlerini otomatik olarak tarar ve Spring konteynerine kaydeder.
Bu sayede, JPA repository arayüzleri üzerinden veri tabanı işlemleri gerçekleştirmek için gerekli altyapı
otomatik olarak sağlanır.
*/
public class OzgecmisPortaliApplication {

	public static void main(String[] args) {
		SpringApplication.run(OzgecmisPortaliApplication.class, args);
	}
}