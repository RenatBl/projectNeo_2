package ru.itis.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Event event;

    @NotBlank(message = "Введите заголовок отчета")
    private String header;    //заголовок отчета

    @NotBlank(message = "Напишите описание отчета")
    private String text;    //описание

    @NotBlank(message = "Введите сумму затрат")
    private Double cost;    //затраты

    private Character currency;    //валюта
}
