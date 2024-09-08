package com.example.clientproductapp.repository;

import com.example.clientproductapp.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Long> {
    List<Action> findByBeginDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate beginDate, LocalDate endDate);
}
