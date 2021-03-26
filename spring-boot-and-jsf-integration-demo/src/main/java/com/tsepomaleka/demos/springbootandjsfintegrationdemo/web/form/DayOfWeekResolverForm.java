package com.tsepomaleka.demos.springbootandjsfintegrationdemo.web.form;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Component
@SessionScope
public class DayOfWeekResolverForm implements ViewFormBean {

    private int year;
    private int month;
    private int dayOfMonth;

    private String dayOfWeekValue;
}