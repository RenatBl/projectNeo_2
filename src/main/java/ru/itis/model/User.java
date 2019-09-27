package ru.itis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min=3, max=20,
            message="Имя пользователя должно содержать от 3 до 20 символов.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="Имя пользователя должно быть буквенно-цифровым, без пробелов.")
    private String username;

    @Size(min=6, max=20,
            message="Пароль должен содержать не менее 6 символов.")
    private String password;

    @Size(min=3,
            message="Имя должно содержать минимум 3 символа.")
    private String name;

    @Size(min=3,
            message="Фамилия должна содержать минимум 3 символа.")
    private String surname;

    private String patronymic;

    private Character sex;

    private Date birth;

    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Некорректный e-mail адрес.")
    private String email;

    @Pattern(regexp = "/^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$/",
            message="Некорректный номер телефона.")
    private String phoneNumber;
}
