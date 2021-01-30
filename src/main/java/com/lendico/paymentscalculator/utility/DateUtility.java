package com.lendico.paymentscalculator.utility;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtility {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public String getNextMonthDate(String dateInString){
        LocalDateTime dateTime = LocalDateTime.parse(dateInString,formatter);
        return (dateTime.plusMonths(1).format(formatter));

    }
}
