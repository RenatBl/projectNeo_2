package ru.itis.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.model.enums.UserRole;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {
    @Builder    //AUTHOR
    public User(String username, String password, String companyName, String inn, String ogrn, String email,
                String phoneNumber) {
        this.username = username;
        this.password = password;
        this.companyName = companyName;
        this.inn = inn;
        this.ogrn = ogrn;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Builder    //USER
    public User(String username, String password, String name, String surname, String patronymic, Character sex,
                Date birth, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.birth = birth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20, message = "Имя пользователя должно содержать от 3 до 20 символов.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Имя пользователя должно быть буквенно-цифровым, без пробелов.")
    private String username;

    @Size(min = 6, max = 20,
            message = "Пароль должен содержать не менее 6 символов.")
    private String password;

    @Size(min = 2, message = "Имя должно содержать минимум 2 символа.")
    private String name;

    private String companyName;

    private String inn;

    private String ogrn;

    @Size(min = 3, message = "Фамилия должна содержать минимум 3 символа.")
    private String surname;

    private String patronymic;

    private Character sex;

    private Date birth;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Некорректный e-mail адрес.")
    private String email;

    @Pattern(regexp = "/^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$/",
            message = "Некорректный номер телефона.")
    private String phoneNumber;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
