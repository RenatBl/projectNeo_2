package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
