package com.tsepomaleka.demos.springbootandjsfintegrationdemo.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class DayOfWeekResolverServiceImpl implements DayOfWeekResolverService {

    @Override
    public DayOfWeek determineDayOfWeek(final LocalDate effectiveDate) {
        if (effectiveDate == null) {
            throw new IllegalArgumentException("The effective date cannot be null");
        }

        return effectiveDate.getDayOfWeek();
    }
}