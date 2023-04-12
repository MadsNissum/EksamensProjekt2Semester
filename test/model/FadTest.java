package model;

import application.controller.Controller;
import application.model.Fad;
import application.model.Tap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void getLedigPladsIFad_20_Liter() {
        Tap tap = new Tap(20);
        Fad fad = new Fad("Burbon", 32, "Texas");
        fad.addTap(tap);

        double faktiskPladsIFad = fad.getLedigPladsIFad();

        double forventetPladsIFad = 12;
        assertEquals(forventetPladsIFad, faktiskPladsIFad);
    }

    @Test
    void getLedigPladsIFad_0_Liter() {
        Tap tap = new Tap(0);
        Fad fad = new Fad("Burbon", 32, "Texas");
        fad.addTap(tap);

        double faktiskPladsIFad = fad.getLedigPladsIFad();

        double forventetPladsIFad = 32;
        assertEquals(forventetPladsIFad, faktiskPladsIFad);
    }

    @Test
    void getLiterIFad_20_Liter() {
        Tap tap = new Tap(20);
        Fad fad = new Fad("Burbon", 32, "Texas");
        fad.addTap(tap);

        double faktiskLiterIFad = fad.getLiterIFad();

        double forventetLiterIFad= 20;
        assertEquals(forventetLiterIFad, faktiskLiterIFad);
    }

    @Test
    void getLiterIFad_0_Liter() {
        Tap tap = new Tap(0);
        Fad fad = new Fad("Burbon", 32, "Texas");
        fad.addTap(tap);

        double faktiskLiterIFad = fad.getLiterIFad();

        double forventetLiterIFad= 0;
        assertEquals(forventetLiterIFad, faktiskLiterIFad);
    }
}