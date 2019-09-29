package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.model.Event;
import ru.itis.model.User;
import ru.itis.repository.EventRepository;
import ru.itis.repository.UserRepository;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/user_list")
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "user_list";
    }

    @GetMapping("/event_moderation")
    public String eventList(Model model) {
        model.addAttribute("events", eventRepository.findAll());

        return "event_moderation";
    }

    @PostMapping
    public String saveUser(@RequestParam("userId")User user, @RequestParam String username) {
        user.setUsername(username);
        userRepository.save(user);

        return "redirect:/user_list";
    }

    @PostMapping
    public String moderateEvent(@RequestParam("eventId") Event event, @RequestParam String state) {
        Boolean b = event.isModerated(state);
        event.setIsModerated(b);
        eventRepository.save(event);

        return "redirect:/event_moderation";
    }
}
