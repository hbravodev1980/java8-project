package com.investigation.java8.dateapi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class App {
    private void verifyDate() {
        LocalDate date1 = LocalDate.of(1991, Month.APRIL, 12);
        LocalDate date2 = LocalDate.now();
        System.out.println(date1.isAfter(date2));
        System.out.println(date1.isBefore(date2));

        LocalTime time1 = LocalTime.of(22, 30, 50);
        LocalTime time2 = LocalTime.now();
        System.out.println(time1.isAfter(time2));
        System.out.println(time1.isBefore(time2));

        LocalDateTime datetime1 = LocalDateTime.of(1992, Month.AUGUST, 21, 22, 25, 30);
        LocalDateTime datetime2 = LocalDateTime.now();
        System.out.println(datetime1.isAfter(datetime2));
        System.out.println(datetime1.isBefore(datetime2));
    }

    private void measureTime() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(3000);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
    }

    private void periodBetweenDates() {
        LocalDate bornDate= LocalDate.of(1980, Month.JULY, 13);
        LocalDate currenDate = LocalDate.now();
        Period period = Period.between(bornDate, currenDate);
        System.out.println("Elapsed " + period.getYears() + " years, "
                + period.getMonths() + " months, "
                + period.getDays() + " days, from born "
                + bornDate + " until "
                + currenDate);
    }

    private void convertDate() {
        String date = "13/07/1980";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
        System.out.println(formatter.format(localDate));
    }

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        //app.verifyDate();
        //app.measureTime();
        //app.periodBetweenDates();
        app.convertDate();
    }
}