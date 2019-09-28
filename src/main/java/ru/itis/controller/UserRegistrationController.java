package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.model.User;
import ru.itis.model.enums.UserRole;
import ru.itis.repository.UserRepository;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserRegistrationController {
    private final UserRepository userRepository;

    @Autowired
    public UserRegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User already exists!");
            return "registration";
        }

        user.setRoles(Collections.singleton(UserRole.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}