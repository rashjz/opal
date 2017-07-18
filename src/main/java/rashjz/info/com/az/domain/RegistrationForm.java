package rashjz.info.com.az.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import rashjz.info.com.az.validator.Phone;

/**
 *
 * @author Rashad Javadov
 */
public class RegistrationForm {

    private String userId;

    @NotEmpty(message = "Adınızı daxil edin")
    @NotNull(message = "Adınızı daxil edin")
    private String firstName;

    @NotEmpty(message = "Soyadınızı daxil edin")
    @NotNull(message = "Soyadınızı daxil edin")
    private String lastName;

    @NotEmpty(message = "Mobil nömrənizi daxil edin")
    @Phone(message = "Mobil nömrə yalnış daxil edilmişdir")
    private String phoneno;

    @NotEmpty(message = "Emaili daxil et")
    @Email(message = "Email yalnış daxil edilib")
    private String email;

    @Min(value = 6, message = "Minimal 6 simvoldan ibarət olmalıdır")
    @NotEmpty(message = "Şifrəni daxil et")
    private String passwd;

    @Min(value = 6, message = "Minimal 6 simvoldan ibarət olmalıdır")
    @NotEmpty(message = "Təkrar şifrəni daxil et")
    private String repasswd;

    @NotEmpty(message = "Cinsi daxil et")
    private String gender;

    public RegistrationForm() {
    }

    public RegistrationForm(final String userId, final String firstName, final String lastName, final String phoneno, final String email, final String password, final String gender) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneno = phoneno;
        this.email = email;
        this.passwd = password;
        this.gender = gender;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRepasswd() {
        return repasswd;
    }

    public void setRepasswd(String repasswd) {
        this.repasswd = repasswd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static class Builder {

        private String userId;
        private String firstName;
        private String lastName;
        private String phoneno;
        private String email;
        private String password;
        private String gender;

        public RegistrationForm build() {
            return new RegistrationForm(userId, firstName, lastName, phoneno, email, password, gender);
        }
    }

    @Override
    public String toString() {
        return "UserRegistrationForm{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneno=" + phoneno + ", email=" + email + ", passwd=" + passwd + ", repasswd=" + repasswd + '}';
    }

}
