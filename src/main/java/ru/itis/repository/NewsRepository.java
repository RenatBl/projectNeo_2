package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
