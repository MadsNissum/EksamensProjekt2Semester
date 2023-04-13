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
    void getLiterTilbageIDestillering_26_Liter_4_Taps(){
        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");
        destillering.addTap(new Tap(5));
        destillering.addTap(new Tap(6));
        destillering.addTap(new Tap(7));
        destillering.addTap(new Tap(8));
        double faktiskTilbageLiter = destillering.getLiterTilbageIDestillering();

        double forventetTilbageLiter = 74;
        assertEquals(forventetTilbageLiter, faktiskTilbageLiter);
    }

    @Test
    void getLiterTilbageIDestillering_0_Taps(){
        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");
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

    @Test
    void getLedigLiterIDestillering_0_Liter_0_Taps() {

        Destillering destillering = new Destillering(startDato, slutDato, "Single malt", "Byg", "Snævar aka Sniper", 100, 80, "Birk", "God whisky");

        double faktiskLedigLiter = destillering.getLedigLiterIDestillering();

        double forventetLedigLiter = 0;
        assertEquals(forventetLedigLiter, faktiskLedigLiter);
    }
}