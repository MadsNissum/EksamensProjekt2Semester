package controller;

import application.controller.Controller;
import application.model.Lager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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


}