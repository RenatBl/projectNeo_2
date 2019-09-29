package ru.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.repository.EventRepository;

import java.sql.Date;
import java.util.*;

@Controller
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public String getEvents(Model model) {
        List list = eventRepository.findAll();
        Collections.sort(list, (Comparator<Date>) (o1, o2) -> o1.before(o2) ? -1 : o1.after(o2) ? 1 : 0);
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(list.get(i));
        }
        model.addAttribute("events", arrayList);

        return "events";
    }
}
