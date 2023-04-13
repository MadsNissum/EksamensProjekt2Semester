package application.controller;

import application.model.*;
import application.utility.Utility;
import storage.Storage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {

    /**
     * createFad opretter et fad
     *
     * @param type - Navnet på fadtypen
     * @param kapacitet - Mængden af, hvor meget der kan være i fadet
     * @param oprindelse - Naavnet på, hvor fadet er fra
     * @return fad
     */
    public static Fad createFad(String type, double kapacitet, String oprindelse) {
        Fad fad = new Fad(type, kapacitet, oprindelse);
        Storage.addFad(fad);
        return fad;
    }

    /**
     * createLager opretter et lager
     *
     * @param adresse - Adresse på lageret
     * @param kvm - Størrelsen af lageret angivet i kvadratmeter
     * @param fadKapacitet - Antal pladser til fade på lageret
     * @return lager
     */
    public static Lager createLager(String adresse, double kvm, int fadKapacitet) {
        Lager lager = new Lager(adresse, kvm, fadKapacitet);
        Storage.addLager(lager);
        return lager;
    }

    /**
     * createDestillering opretter en destillering
     *
     * @param startDato - Startdatoen for, hvornår destilleringen startede
     * @param slutDato - Slutdatoen for, hvornår destillering er slut
     * @param maltbatch - Maltbatchen af destilleringen
     * @param kornsort - Kornsorten af destilleringen
     * @param medarbejder - Medarbejderen der har ansvaret for destilleringen
     * @param mængde - Mængden af destilleringen
     * @param alkoholProcent - Alkoholprocenten angives
     * @param rygemateriale - Rygemateriale af destilleringen
     * @param kommentar - En kommentar om destilleringen
     * @return destillering
     */

    public static Destillering createDestillering(LocalDate startDato, LocalDate slutDato, String maltbatch, String kornsort, String medarbejder, double mængde, double alkoholProcent, String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(startDato, slutDato, maltbatch, kornsort, medarbejder, mængde, alkoholProcent, rygemateriale, kommentar);
        Storage.addDestilleringer(destillering);
        return destillering;
    }

    /**
     * createTap opretter et tap
     *
     * @param liter - Antal liter der kan aftappes
     * @param destillering - Destilleringen, der skal aftappes fra
     * @param fad - Fadet, der skal aftappes fra
     * @return tap
     */

    public static Tap createTap(double liter, Destillering destillering, Fad fad) {
        Tap tap = new Tap(liter);
        tap.setDestillering(destillering);
        tap.setFad(fad);
        fad.setLiterIFad(fad.getLiterIFad() + liter);
        Storage.addTap(tap);
        return tap;
    }

    //--------------------------------------------------

    public static void addLager(Lager lager) {
        Storage.addLager(lager);
    }

    public static void addFad(Fad fad) {
        Storage.addFad(fad);
    }

    public static void addDestilleringer(Destillering destillering) {
        Storage.addDestilleringer(destillering);
    }

    public static void addTap(Tap tap) {
        Storage.addTap(tap);
    }

    public static void addWhiskyflaske(WhiskyFlaske whiskeyFlaske) {
        Storage.addWhiskyflasker(whiskeyFlaske);
    }
    //--------------------------------------------------
    public static void removeLager(Lager lager) {
        Storage.removeLager(lager);
    }

    public static void removeFad(Fad fad) {
        Storage.removeFad(fad);
    }

    public static void removeDestilleringer(Destillering destillering) {
        Storage.removeDestilleringer(destillering);
    }

    public static void removeTap(Tap tap) {
        Storage.removeTap(tap);
    }

    public static void removeWhiskyflaske(WhiskyFlaske whiskeyFlaske) {
        Storage.removeWhiskyflaske(whiskeyFlaske);
    }
    //--------------------------------------------------

    public static ArrayList<Lager> getLager() {
        return Storage.getLagerer();
    }

    public static ArrayList<Fad> getFade() {
        return Storage.getFade();
    }

    public static ArrayList<Fad> getIkkeFyldteFade() {
        ArrayList<Fad> fade = new ArrayList<>();

        for (Fad fad : Storage.getFade()) {
            if (fad.getLedigPladsIFad() > 0) {
                fade.add(fad);
            }
        }

        return fade;
    }

    public static ArrayList<Destillering> getDestilleringer() {
        return Storage.getDestilleringer();
    }

    public static ArrayList<Tap> getTaps() {
        return Storage.getTaps();
    }

    public static ArrayList<WhiskyFlaske> getWhiskyflasker() {
        return Storage.getWhiskyFlasker();
    }
    //--------------------------------------------------

    /**
     * updateFad opdaterer et fad
     *
     * @param type - Navnet på fadtypen
     * @param kapacitet - Mængden af, hvor meget der kan være i fadet
     * @param oprindelse - Naavnet på, hvor fadet er fra
     */
    public static void updateFad(Fad fad, String type, double kapacitet, String oprindelse) {
        fad.setType(type);
        fad.setKapacitet(kapacitet);
        fad.setOprindelse(oprindelse);
    }

    /**
     * createLagerPlads opretter et lagerplads
     *
     * @param fad - Fad angives
     * @param reol - Navn/nummer på reolen
     * @param hylde - Navn/nummer på hylden
     * @param plads - Navn/nummer på pladsen
     */
    public static void createLagerPlads(Fad fad, String reol, String hylde, String plads) {
        fad.createLagerPlads(reol, hylde, plads);
    }

    /**
     * addFadTilLager tilføjer et fad til et lager
     *
     * @param fad - Fad angives
     * @param lager - Lager angives
     */

    public static void addFadTilLager(Fad fad, Lager lager) {
        fad.setLager(lager);
    }

    /**
     * updateLager opdaterer et lager
     *
     * @param adresse - Adresse på lageret
     * @param kvm - Størrelsen af lageret angivet i kvadratmeter
     * @param kapacitet - Antal pladser til fade på lageret
     */
    public static void updateLager(Lager lager, String adresse, double kvm, int kapacitet) {
        lager.setAdresse(adresse);
        lager.setKvm(kvm);
        lager.setKapacitet(kapacitet);
    }

    /**
     * updateDestillering opdaterer en destillering
     *
     * @param startDato - Startdatoen for, hvornår destilleringen startede
     * @param slutDato - Slutdatoen for, hvornår destillering er slut
     * @param maltbatch - Maltbatchen af destilleringen
     * @param kornsort - Kornsorten af destilleringen
     * @param medarbejder - Medarbejderen der har ansvaret for destilleringen
     * @param mængde - Mængden af destilleringen
     * @param alkoholProcent - Alkoholprocenten angives
     * @param rygemateriale - Rygemateriale af destilleringen
     * @param kommentar - En kommentar om destilleringen
     */

    public static void updateDestillering(Destillering destillering, LocalDate startDato, LocalDate slutDato, String maltbatch,
                                          String kornsort, String medarbejder, double mængde, double alkoholProcent,
                                          String rygemateriale, String kommentar) {
        destillering.setStartDato(startDato);
        destillering.setSlutDato(slutDato);
        destillering.setMaltbatch(maltbatch);
        destillering.setKornsort(kornsort);
        destillering.setMedarbejder(medarbejder);
        destillering.setKapacitet(mængde);
        destillering.setAlkoholProcent(alkoholProcent);
        destillering.setRygemateriale(rygemateriale);
        destillering.setKommentar(kommentar);
    }

    /**
     * getFadeWhisky checker alle fade
     * nyesteDato sættes til null
     * Hvis taps på fadet ikke er tomt, checkes alle taps på fadet
     * nyesteDato checkes for lige med null eller at datoen ikke er før destilleringens slutdato
     * nyesteDato checkes for ikke lige med null, og om nyesteDato er før i dag
     * Fadet tilføjes
     *
     * @return liste af fade
     */
    public static ArrayList<Fad> getFadeWhisky() {
        ArrayList<Fad> fade = new ArrayList<>();
        for (Fad fad : Storage.getFade()) {
            LocalDate nyesteDato = null;
            if (!fad.getTaps().isEmpty()) {
                for (Tap tap : fad.getTaps()) {
                    if (nyesteDato == null || nyesteDato.isBefore(tap.getDestillering().getSlutDato())) {
                        nyesteDato = tap.getDestillering().getSlutDato();
                    }
                }
            }
            if (nyesteDato != null && nyesteDato.isBefore(LocalDate.now())) {
                fade.add(fad);
            }
        }
        return fade;
    }

    /**
     * createFlasker opretter flasker
     *
     * @param fad - Fad angives
     * @param antal - Antallet af flasker der skal oprettes
     * @param milliliter - Antal milliliter, der skal være i hver flaske
     * @param navn - Navnet på flasken
     */
    public static void createFlasker(Fad fad, int antal, double milliliter, String navn) {
        String batchID = Utility.randomUUID(16);
        //TODO daos check data base uuid bombombmo

        if ((milliliter/1000) * antal > fad.getLiterIFad()) {
            throw new RuntimeException("Der er ikke nok væske til at lave flasker!");
        }

        fad.setLiterIFad(fad.getLiterIFad() - (milliliter/1000) * antal);

        for (int i = 0; i < antal; i++) {
            WhiskyFlaske whiskeyFlaske = new WhiskyFlaske(milliliter, navn, batchID);
            whiskeyFlaske.setFad(fad);
            Storage.addWhiskyflasker(whiskeyFlaske);
        }
        WhiskyFlaske.resetIndex();
    }

    /**
     * getWhiskyFlaskerSearch er en søgefunktion der bruges til at søge efter flasker
     * Der løbes igennem alle flasker og checkes at store og små bogstaver ikke har nogen betydning
     * BatchID checkes også, så der også kan søges efter den
     *
     * @param str - String værdi
     * @return liste af whiskyflasker
     */
    public static ArrayList<WhiskyFlaske> getWhiskyFlaskerSearch(String str) {
        ArrayList<WhiskyFlaske> flasker = new ArrayList<>();

        ArrayList<WhiskyFlaske> alleFlasker = Storage.getWhiskyFlasker();

        for (WhiskyFlaske whiskeyFlaske : alleFlasker) {
            if (whiskeyFlaske.toString().toLowerCase().contains(str.toLowerCase()) || whiskeyFlaske.getBatchID().toLowerCase().contains(str.toLowerCase())) {
                flasker.add(whiskeyFlaske);
            }
        }


        return flasker;
    }

    public static void initController() {
        Fad fad1 = createFad("Burbon", 32, "Texas");
        Fad fad2 = createFad("Sherry", 64, "England");
        Fad fad3 = createFad("Single malt", 120, "USA");
        Fad fad4 = createFad("Rødvin", 60, "Tyskland");

        Lager lager1 = createLager("Klostertorvet 11", 52, 100);
        Lager lager2 = createLager("Rosenhøj 60", 20, 50);
        Lager lager3 = createLager("Randersvej 243", 200, 1000);

        addFadTilLager(fad1, lager1);
        fad1.createLagerPlads("B", "2", "130");
        addFadTilLager(fad2, lager3);
        fad2.createLagerPlads("A", "0", "B14");
        addFadTilLager(fad3, lager2);
        fad3.createLagerPlads("Y", "5", "80H");


        createDestillering(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 4, 5), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");
        createDestillering(LocalDate.of(2023, 3, 28), LocalDate.of(2027, 3, 29), "Single malt", "Hvede", "Adam", 800, 90, "Eg", "Smager er jord");
        Destillering destillering1 = createDestillering(LocalDate.of(2019, 1, 1), LocalDate.of(2022, 4, 5), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");
        Destillering destillering2 = createDestillering(LocalDate.of(2018,1,1), LocalDate.of(2023,1,1), "Single malt", "Hvede", "Adam", 800, 80, "Eg", "Banger");

        Tap tap1 = createTap(60,destillering1,fad4);
        Tap tap2 = createTap(64,destillering2,fad2);

    }
}
