package controller;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @Test
    void checkWhiskyTid() {
        Fad fad = new Fad("Burbon", 32, "Texas");
        Destillering destillering = new Destillering(LocalDate.of(2020, 3, 27), LocalDate.of(2023, 3, 27), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");

        int faktiskWhiskyTid = Controller.checkWhiskyTid(fad,destillering);

        int forventetWhiskTid = 3;
        assertEquals(forventetWhiskTid, faktiskWhiskyTid);
    }
}