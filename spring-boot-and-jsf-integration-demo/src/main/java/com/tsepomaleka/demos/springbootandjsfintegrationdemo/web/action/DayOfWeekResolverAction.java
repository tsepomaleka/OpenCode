package com.tsepomaleka.demos.springbootandjsfintegrationdemo.web.action;

import com.tsepomaleka.demos.springbootandjsfintegrationdemo.service.DayOfWeekResolverService;
import com.tsepomaleka.demos.springbootandjsfintegrationdemo.web.form.DayOfWeekResolverForm;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import lombok.RequiredArgsConstructor;

@Component
@RequestScope
@RequiredArgsConstructor
public class DayOfWeekResolverAction implements RequestActionBean {

    private final DayOfWeekResolverForm dayOfWeekResolverForm;
    private final DayOfWeekResolverService dayOfWeekResolverService;

    public void determineDayOfWeek() {

        final var effectiveDate = LocalDate.of(dayOfWeekResolverForm.getYear(),
            dayOfWeekResolverForm.getMonth(),
            dayOfWeekResolverForm.getDayOfMonth());

        var dayOfWeek = dayOfWeekResolverService.determineDayOfWeek(effectiveDate);

        dayOfWeekResolverForm.setDayOfWeekValue(dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));
    }
}
