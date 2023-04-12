package controller;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ControllerTest {
    Fad fade;
    @Test
    void checkWhiskyTid_3_Aar() {
        Destillering destillering = new Destillering(LocalDate.of(2020, 3, 27), LocalDate.of(2023, 3, 27), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");

        int faktiskWhiskyTid = Controller.checkWhiskyTid(destillering);

        int forventetWhiskTid = 3;
        assertEquals(forventetWhiskTid, faktiskWhiskyTid);
    }

    @Test
    void checkWhiskyTid_2_Aar() {
        Destillering destillering = new Destillering(LocalDate.of(2020, 3, 27), LocalDate.of(2023, 3, 26), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");

        int faktiskWhiskyTid = Controller.checkWhiskyTid(destillering);

        int forventetWhiskTid = 2;
        assertEquals(forventetWhiskTid, faktiskWhiskyTid);
    }


    @Test
    void getFadeWhisky_Burbon() {
        Fad fad = new Fad("Burbon", 32, "Texas");
        ArrayList<Fad> mockList = mock(ArrayList.class);
        when(mockList.get(0)).thenReturn(fad);

        Fad firstElement = mockList.get(0);

        assertEquals(fad, firstElement);
    }

    @Test
    void getFadeWhisky_Sherry() {
        Fad fad = new Fad("Sherry", 64, "England");
        fade = mock(Fad.class);

     //   when(fade.).thenReturn();

       // Fad firstElement = fade.

        //assertEquals(fad, firstElement);
    }
}