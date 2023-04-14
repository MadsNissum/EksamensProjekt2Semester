package controller;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Lager;
import application.model.Tap;
import org.junit.jupiter.api.Test;
import storage.Storage;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

class ControllerTest {

    @Test
    void TC1_Create_Lager_Forkert_Adresse_Input() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Controller.createLager("", 100, 100));

        String expectedMessage = "Indtast en Adresse";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void TC2_Create_Lager_Forkert_Adresse_NullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Controller.createLager(null, 100, 100));

        String expectedMessage = "Indtast en Adresse";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void TC3_Create_Lager_Forkert_Kvm_Input_Minus_1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Controller.createLager("Vejen 10", -1, 100));

        String expectedMessage = "Indtast et tal i Kvm";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void TC4_Create_Lager_Forkert_Kvm_Input_Minus_100() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Controller.createLager("Vejen 10", -100, 100));

        String expectedMessage = "Indtast et tal i Kvm";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void TC5_Create_Lager_Forkert_FadKapacitet_Input_Minus_1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Controller.createLager("Vejen 10", 100, -1));

        String expectedMessage = "Indtast et tal i Kapacitet";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void TC6_Create_Lager_Forkert_FadKapacitet_Input_Minus_100() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Controller.createLager("Vejen 10", 100, -100));

        String expectedMessage = "Indtast et tal i Kapacitet";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void TC7_Create_Lager_Success() {
        Lager actualLager = Controller.createLager("Vejen 10", 100, 100);

        assertNotNull(actualLager);

        Lager expectedLager = new Lager("Vejen 10", 100 ,100);

        assertTrue(expectedLager.getAdresse().equals(actualLager.getAdresse()) && expectedLager.getKvm() == actualLager.getKvm() && expectedLager.getKapacitet() == actualLager.getKapacitet());
    }



    @Test
    void getFadeWhisky_Check_Size_Og_Type() {
        Fad fad = new Fad("Burbon", 32, "Texas");
        Fad fad2 = new Fad("Sherry", 64, "England");
        Fad fad3 = new Fad("Single malt", 120, "USA");
        Fad fad4 = new Fad("Rødvin", 60, "Tyskland");
        Tap tap = new Tap(20);
        Tap tap2 = new Tap(10);
        Tap tap3 = new Tap(15);
        Tap tap4 = new Tap(5);

        tap.setFad(fad);
        tap.setDestillering(new Destillering(LocalDate.of(2020, 3, 1), LocalDate.of(2023, 3, 1), "Single malt", "Byg", "Sniper", 500, 80, "Birk", "God whisky"));

        tap2.setFad(fad2);
        tap2.setDestillering(new Destillering(LocalDate.of(2018, 3, 28), LocalDate.of(2021, 3, 28), "Single malt", "Hvede", "Adam", 800, 90, "Eg", "Smager er jord"));

        tap3.setFad(fad3);
        tap3.setDestillering(new Destillering(LocalDate.of(2019, 1, 1), LocalDate.of(2022, 4, 5), "Single malt", "Byg", "Sniper", 500, 80, "Birk", "God whisky"));

        tap4.setFad(fad4);
        tap4.setDestillering(new Destillering(LocalDate.of(2018,1,1), LocalDate.of(2023,1,1), "Single malt", "Hvede", "Adam", 800, 80, "Eg", "Banger"));

        Storage.addFad(fad);
        Storage.addFad(fad2);
        Storage.addFad(fad3);
        Storage.addFad(fad4);

        ArrayList<Fad> fade = Controller.getFadeWhisky();

        assertEquals(fade.size(), 4);
        assertEquals(fade.get(0).getType(),"Burbon");
        assertEquals(fade.get(1).getType(), "Sherry");
        assertEquals(fade.get(2).getType(), "Single malt");
        assertEquals(fade.get(3).getType(), "Rødvin");
    }

}