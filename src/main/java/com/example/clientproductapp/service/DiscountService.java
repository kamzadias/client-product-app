package com.example.clientproductapp.service;

import com.example.clientproductapp.dto.DiscountDto;
import com.example.clientproductapp.entity.Discount;
import com.example.clientproductapp.repository.DiscountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;
    private final ModelMapper modelMapper;

    public DiscountService(DiscountRepository discountRepository, ModelMapper modelMapper) {
        this.discountRepository = discountRepository;
        this.modelMapper = modelMapper;
    }

    public List<DiscountDto> getActiveDiscounts(LocalDate date) {
        List<Discount> discounts = discountRepository.findByBeginDateLessThanEqualAndEndDateGreaterThanEqual(date, date);
        return discounts.stream()
                .map(discount -> modelMapper.map(discount, DiscountDto.class))
                .toList();
    }
}
