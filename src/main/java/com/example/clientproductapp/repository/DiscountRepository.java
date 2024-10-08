package com.example.clientproductapp.repository;

import com.example.clientproductapp.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    List<Discount> findByBeginDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate beginDate, LocalDate endDate);
}
