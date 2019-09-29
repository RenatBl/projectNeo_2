package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.repository.EventRepository;

@Controller
public class EventModeratorController {
    private final EventRepository eventRepository;

    @Autowired
    public EventModeratorController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public String getEventsList(Model model) {
        model.addAttribute("events", eventRepository.findAll());

        return "event_moderator";
    }
}
