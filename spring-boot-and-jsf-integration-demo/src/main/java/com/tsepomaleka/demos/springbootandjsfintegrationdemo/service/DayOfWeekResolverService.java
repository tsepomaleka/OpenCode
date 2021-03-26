package com.tsepomaleka.demos.springbootandjsfintegrationdemo.service;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface DayOfWeekResolverService {

    DayOfWeek determineDayOfWeek(final LocalDate effectiveDate);
}
