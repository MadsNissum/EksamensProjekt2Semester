package controller;

import application.controller.Controller;
import application.model.Destillering;
import application.model.Fad;
import application.model.Tap;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import storage.Storage;

import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

class ControllerTest {


    @BeforeEach
    void setup() {
        Fad fad = new Fad("Burbon", 32, "Texas");
        Fad fad2 = new Fad("Sherry", 64, "England");
        Fad fad3 = new Fad("Single malt", 120, "USA");
        Fad fad4 = new Fad("Rødvin", 60, "Tyskland");
        Tap tap = new Tap(20);
        Tap tap2 = new Tap(10);
        Tap tap3 = new Tap(15);
        Tap tap4 = new Tap(5);

        tap.setFad(fad);
        tap.setDestillering(new Destillering(LocalDate.of(2020, 3, 1), LocalDate.of(2023, 3, 1), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky"));

        tap2.setFad(fad2);
        tap2.setDestillering(new Destillering(LocalDate.of(2018, 3, 28), LocalDate.of(2021, 3, 28), "Single malt", "Hvede", "Adam", 800, 90, "Eg", "Smager er jord"));

        tap3.setFad(fad3);
        tap3.setDestillering(new Destillering(LocalDate.of(2019, 1, 1), LocalDate.of(2022, 4, 5), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky"));

        tap4.setFad(fad4);
        tap4.setDestillering(new Destillering(LocalDate.of(2018,1,1), LocalDate.of(2023,1,1), "Single malt", "Hvede", "Adam", 800, 80, "Eg", "Banger"));

        Storage.addFad(fad);
        Storage.addFad(fad2);
        Storage.addFad(fad3);
        Storage.addFad(fad4);
    }

    @Test
    void getFadeWhisky_Check_Size_Og_Type() {
        ArrayList<Fad> fade = Controller.getFadeWhisky();

        assertEquals(fade.size(), 4);
        assertEquals(fade.get(0).getType(),"Burbon");
        assertEquals(fade.get(1).getType(), "Sherry");
        assertEquals(fade.get(2).getType(), "Single malt");
        assertEquals(fade.get(3).getType(), "Rødvin");
    }

}