package controller;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @Test
    void checkWhiskyTid() {
        Destillering destillering = new Destillering(LocalDate.of(2020, 3, 27), LocalDate.of(2023, 3, 27), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");

        int faktiskWhiskyTid = Controller.checkWhiskyTid(destillering);

        int forventetWhiskTid = 3;
        assertEquals(forventetWhiskTid, faktiskWhiskyTid);
    }

    @Test
    void getFadeWhisky() {

        Destillering destillering = new Destillering(LocalDate.of(2020, 3, 27), LocalDate.of(2023, 3, 27), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");
        LocalDate tid = LocalDate.now();

        ArrayList<Fad> faktiskFadeWhisky = Controller.getFadeWhisky();

        ArrayList<Fad> forventetFadeWhisky =

        assertEquals(forventetFadeWhisky, faktiskFadeWhisky);
    }
}