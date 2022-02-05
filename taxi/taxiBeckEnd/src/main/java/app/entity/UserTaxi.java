package app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "userEmail")}
)
public class UserTaxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userSecondName;
    private int userRating;


    @NotBlank
    @Size(max = 20)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles;

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> roles) {
        this.userRoles = roles;
    }

    public UserTaxi() {
    }

    public UserTaxi(String name, String email, String password) {
        this.username = name;
        this.userEmail = email;
        this.userPassword = password;
    }

    @Transient
    private String passwordConfirm;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String user_email) {
        this.userEmail = user_email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String user_password) {
        this.userPassword = user_password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String user_first_name) {
        this.userFirstName = user_first_name;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String user_last_name) {
        this.userLastName = user_last_name;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String user_second_name) {
        this.userSecondName = user_second_name;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int user_rating) {
        this.userRating = user_rating;
    }
}
