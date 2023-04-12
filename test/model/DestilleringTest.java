package model;

import application.model.Destillering;
import application.model.Tap;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {
    LocalDate startDato =  LocalDate.of(2020,4,11);
    LocalDate slutDato = LocalDate.of(2023,4,11);

    @Test
    void getLiterTilbageIDestillering_40_Liter(){
        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");
        Tap tap = new Tap(40);
        destillering.addTap(tap);
        double faktiskTilbageLiter = destillering.getLiterTilbageIDestillering();

        double forventetTilbageLiter = 60;
        assertEquals(forventetTilbageLiter, faktiskTilbageLiter);
    }

    @Test
    void getLiterTilbageIDestillering_0_Liter(){
        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");
        Tap tap = new Tap(0);
        destillering.addTap(tap);
        double faktiskTilbageLiter = destillering.getLiterTilbageIDestillering();

        double forventetTilbageLiter = 100;
        assertEquals(forventetTilbageLiter, faktiskTilbageLiter);
    }


    @Test
    void getLedigLiterIDestillering_40_Liter() {

        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");
        Tap tap = new Tap(40);
        destillering.addTap(tap);

        double faktiskLedigLiter = destillering.getLedigLiterIDestillering();

        double forventetLedigLiter = 40;
        assertEquals(forventetLedigLiter, faktiskLedigLiter);
    }

    @Test
    void getLedigLiterIDestillering_0_Liter() {

        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");
        Tap tap = new Tap(0);
        destillering.addTap(tap);

        double faktiskLedigLiter = destillering.getLedigLiterIDestillering();

        double forventetLedigLiter = 0;
        assertEquals(forventetLedigLiter, faktiskLedigLiter);
    }
}