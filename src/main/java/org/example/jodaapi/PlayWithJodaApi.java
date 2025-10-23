package org.example.jodaapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PlayWithJodaApi{
    public static void main(String[] args){
        LocalDate localDate = LocalDate.parse("2025-10-25");
        System.out.println("localDate :" + localDate);
        final String format = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("formatted date :" + format);
    }
}
