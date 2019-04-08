package com.tsepomaleka.integratingspringandjsf.web.form;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class DayOfWeekResolverForm implements Serializable
{
  private int year;
  private int month;
  private int dayOfMonth;

  private String dayOfWeek;

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getDayOfMonth()
  {
    return dayOfMonth;
  }

  public void setDayOfMonth(int dayOfMonth)
  {
    this.dayOfMonth = dayOfMonth;
  }

  public String getDayOfWeek()
  {
    return dayOfWeek;
  }

  public void setDayOfWeek(String dayOfWeek)
  {
    this.dayOfWeek = dayOfWeek;
  }
}
