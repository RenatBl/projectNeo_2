package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
