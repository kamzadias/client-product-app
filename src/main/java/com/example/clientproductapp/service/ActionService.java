package com.example.clientproductapp.service;

import com.example.clientproductapp.dto.ActionDto;
import com.example.clientproductapp.entity.Action;
import com.example.clientproductapp.repository.ActionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActionService {

    private final ActionRepository actionRepository;
    private final ModelMapper modelMapper;

    public ActionService(ActionRepository actionRepository, ModelMapper modelMapper) {
        this.actionRepository = actionRepository;
        this.modelMapper = modelMapper;
    }

    public List<ActionDto> getActiveActions(LocalDate date) {
        List<Action> actions = actionRepository.findByBeginDateLessThanEqualAndEndDateGreaterThanEqual(date, date);
        return actions.stream()
                .map(action -> modelMapper.map(action, ActionDto.class))
                .toList();
    }
}
