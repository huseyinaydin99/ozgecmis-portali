package tr.com.huseyinaydin.resumeportal.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//بسم الله الرحمن الرحيم

/**
 *
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot
 *
 */

@Entity
@Table(name = "UserProfiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;
    private int theme;
    private String summary;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;

    /*
    UserProfile sınıfına bir iş ilanları (jobs) listesi ekledim ve her bir kullanıcı profiliyle ilişkili
    işleri saklamak için @OneToMany ilişkilendirmesi kullandım. İlişkinin bütünlüğünü sağlamak ve yetim
    verileri temizlemek için CascadeType.ALL ve orphanRemoval = true özelliklerini tanımladım.

    CascadeType.ALL, ilişkili varlıklar üzerinde yapılan tüm işlemlerin (persist, merge, remove, refresh, detach)
    otomatik olarak ilişkilendirilmiş varlıklara da uygulanmasını sağlar.

    orphanRemoval = true, bir ilişkiden kaldırılan veya ilişki tarafından artık referans
    edilmeyen bağlı varlıkların otomatik olarak silinmesini sağlar.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    List<Job> jobs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    List<Education> educations = new ArrayList<>();

    /*
    @ElementCollection kullanıldığında, veriler aynı tabloda tutulmaz.
    Bunun yerine, JPA, bu koleksiyonu ayrı bir tabloya kaydeder.
    Bu yeni tablo, koleksiyon elemanlarını saklar ve ilgili ana varlıkla
    bir ilişki kurar. Yeni oluşturulan tablo genellikle iki sütun içerir:
    biri ana varlığın id'sini (yani UserProfile'ın id'si),
    diğeri ise koleksiyon elemanlarını (bu örnekte String değerlerini) tutar.
    Bu şekilde, koleksiyon elemanları ayrı bir tabloda tutulur, ancak ana varlıkla ilişkili kalır.
    */
    @ElementCollection(targetClass = String.class)
    List<String> skills = new ArrayList<>();

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}