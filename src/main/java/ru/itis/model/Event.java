package ru.itis.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "event")
@AllArgsConstructor
@RequiredArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tag;
    private String text;
    private Date deadline;
    private Long target;
    private Long picking;   //сколько собрано на данный момент
    private Boolean isModerated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Boolean isModerated(String s) {
        return s.equals("Moderated");
    }
}
