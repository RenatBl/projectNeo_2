package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.model.User;
import ru.itis.repository.UserRepository;

import java.sql.Date;

@Controller
public class UserAccountController {
    private final UserRepository userRepository;

    @Autowired
    public UserAccountController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user_account")
    public String getUserAccount(Model model, @RequestParam("user_id") User user) {
        model.addAttribute("users", user);

        return "user_account";
    }

    @PostMapping("/user_account_page")
    public String editUser(Model model, @RequestParam("user_id") User user, @RequestParam String username,
                           @RequestParam String password, @RequestParam String name, @RequestParam String surname,
                           @RequestParam String patronymic, @RequestParam Character sex, @RequestParam Date birth,
                           @RequestParam String email, @RequestParam String phoneNumber) {
        if (username != null && !username.equals("")) {
            user.setUsername(username);
        } else if (password != null && !password.equals("")) {
            user.setPassword(password);
        } else if (name != null && !name.equals("")) {
            user.setName(name);
        } else if (surname != null && !surname.equals("")) {
            user.setSurname(surname);
        } else if (patronymic != null && !patronymic.equals("")) {
            user.setPatronymic(patronymic);
        } else if (sex != null) {
            user.setSex(sex);
        } else if (birth != null) {
            user.setBirth(birth);
        } else if (email != null && !email.equals("")) {
            user.setEmail(email);
        } else if (phoneNumber != null && !phoneNumber.equals("")) {
            user.setPhoneNumber(phoneNumber);
        }

        userRepository.save(user);

        return "redirect:/user_account";
    }
}
