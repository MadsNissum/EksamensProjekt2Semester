package model;

import application.controller.Controller;
import application.model.Fad;
import application.model.Tap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void getLedigPladsIFad() {
        Tap tap = new Tap(20);
        Fad fad = new Fad("Burbon", 32, "Texas");
        fad.addTap(tap);

        double faktiskPladsIFad = fad.getLedigPladsIFad();

        double forventetPladsIFad = 12;
        assertEquals(forventetPladsIFad, faktiskPladsIFad);
    }

    @Test
    void getLiterIFad() {
        Tap tap = new Tap(20);
        Fad fad = new Fad("Burbon", 32, "Texas");
        fad.addTap(tap);

        double faktiskLiterIFad = fad.getLiterIFad();

        double forventetLiterIFad= 20;
        assertEquals(forventetLiterIFad, faktiskLiterIFad);
    }
}