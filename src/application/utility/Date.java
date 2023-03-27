package application.utility;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Date {
    public static LocalDate checkerDate(String str) {
        LocalDate dato;
        try {
            dato = LocalDate.parse(str);
        } catch (DateTimeParseException e) {
            dato = null;
        }
        return dato;
    }


    }
