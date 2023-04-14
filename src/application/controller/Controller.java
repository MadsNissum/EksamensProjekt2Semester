package application.controller;

import application.model.*;
import application.utility.Utility;
import storage.Storage;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    /**
     * createFad opretter et fad
     *
     * @param type       - Navnet på fad typen
     * @param kapacitet  - Mængden af, hvor meget der kan være i fadet
     * @param oprindelse - Navnet på, hvor fadet er fra
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
     * @param adresse      - Adresse på lageret
     * @param kvm          - Størrelsen af lageret angivet i kvadratmeter
     * @param fadKapacitet - Antal pladser til fade på lageret
     * @return lager
     */
    public static Lager createLager(String adresse, double kvm, int fadKapacitet) {
        if (adresse == null || adresse.length() == 0) {
            throw new IllegalArgumentException("Indtast en Adresse");
        } else if (kvm < 0) {
            throw new IllegalArgumentException("Indtast et tal i Kvm");
        } else if (fadKapacitet < 0) {
            throw new IllegalArgumentException("Indtast et tal i Kapacitet");
        } else {
            Lager lager = new Lager(adresse, kvm, fadKapacitet);
            Storage.addLager(lager);
            return lager;
        }
    }

    /**
     * createDestillering opretter en destillering
     *
     * @param startDato      - Startdatoen for, hvornår destilleringen startede
     * @param slutDato       - Slutdatoen for, hvornår destillering er slut
     * @param maltbatch      - Maltbatchen af destilleringen
     * @param kornsort       - Kornsorten af destilleringen
     * @param medarbejder    - Medarbejderen der har ansvaret for destilleringen
     * @param liter          - Mængden af destilleringen
     * @param alkoholProcent - Alkoholprocenten angives
     * @param rygemateriale  - Rygemateriale af destilleringen
     * @param kommentar      - En kommentar om destilleringen
     * @return destillering
     */

    public static Destillering createDestillering(LocalDate startDato, LocalDate slutDato, String maltbatch, String kornsort, String medarbejder, double liter, double alkoholProcent, String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(startDato, slutDato, maltbatch, kornsort, medarbejder, liter, alkoholProcent, rygemateriale, kommentar);
        Storage.addDestilleringer(destillering);
        return destillering;
    }

    /**
     * createTap opretter et tap
     *
     * @param liter        - Antal liter der kan aftappes
     * @param destillering - Destilleringen, der skal aftappes fra
     * @param fad          - Fadet, der skal aftappes fra
     */
    public static void createTap(double liter, Destillering destillering, Fad fad) {
        Tap tap = new Tap(liter);
        tap.setDestillering(destillering);
        tap.setFad(fad);
        fad.setLiterIFad(fad.getLiterIFad() + liter);
        Storage.addTap(tap);
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

    public static ArrayList<WhiskyFlaske> getWhiskyflasker() {
        return Storage.getWhiskyFlasker();
    }
    //--------------------------------------------------

    /**
     * updateFad opdaterer et fad
     *
     * @param type       - Navnet på fad typen
     * @param kapacitet  - Mængden af, hvor meget der kan være i fadet
     * @param oprindelse - Navnet på, hvor fadet er fra
     */
    public static void updateFad(Fad fad, String type, double kapacitet, String oprindelse) {
        fad.setType(type);
        fad.setKapacitet(kapacitet);
        fad.setOprindelse(oprindelse);
    }

    /**
     * createLagerPlads opretter et lagerplads
     *
     * @param fad   - Fad angives
     * @param reol  - Navn/nummer på reolen
     * @param hylde - Navn/nummer på hylden
     * @param plads - Navn/nummer på pladsen
     */
    public static void createLagerPlads(Fad fad, String reol, String hylde, String plads) {
        fad.createLagerPlads(reol, hylde, plads);
    }

    /**
     * addFadTilLager tilføjer et fad til et lager
     *
     * @param fad   - Fad angives
     * @param lager - Lager angives
     */

    public static void addFadTilLager(Fad fad, Lager lager) {
        fad.setLager(lager);
    }

    /**
     * updateLager opdaterer et lager
     *
     * @param adresse   - Adresse på lageret
     * @param kvm       - Størrelsen af lageret angivet i kvadratmeter
     * @param kapacitet - Antal pladser til fade på lageret
     */
    public static void updateLager(Lager lager, String adresse, double kvm, int kapacitet) {
        if (adresse.length() == 0) {
            throw new IllegalArgumentException("Indtast en Adresse");
        } else if (kvm < 0) {
            throw new IllegalArgumentException("Indtast et tal i Kvm");
        } else if (kapacitet < 0) {
            throw new IllegalArgumentException("Indtast et tal i Kapacitet");
        } else {
            lager.setAdresse(adresse);
            lager.setKvm(kvm);
            lager.setKapacitet(kapacitet);
        }
    }

    /**
     * updateDestillering opdaterer en destillering
     *
     * @param startDato      - Startdatoen for, hvornår destilleringen startede
     * @param slutDato       - Slutdatoen for, hvornår destillering er slut
     * @param maltbatch      - Maltbatchen af destilleringen
     * @param kornsort       - Kornsorten af destilleringen
     * @param medarbejder    - Medarbejderen der har ansvaret for destilleringen
     * @param liter          - Mængden af destilleringen
     * @param alkoholProcent - Alkoholprocenten angives
     * @param rygemateriale  - Rygemateriale af destilleringen
     * @param kommentar      - En kommentar om destilleringen
     */

    public static void updateDestillering(Destillering destillering, LocalDate startDato, LocalDate slutDato, String maltbatch,
                                          String kornsort, String medarbejder, double liter, double alkoholProcent,
                                          String rygemateriale, String kommentar) {
        destillering.setStartDato(startDato);
        destillering.setSlutDato(slutDato);
        destillering.setMaltbatch(maltbatch);
        destillering.setKornsort(kornsort);
        destillering.setMedarbejder(medarbejder);
        destillering.setKapacitet(liter);
        destillering.setAlkoholProcent(alkoholProcent);
        destillering.setRygemateriale(rygemateriale);
        destillering.setKommentar(kommentar);
    }

    /**
     * getFadeWhisky returnerer alle færdiglavede fade med whiskyer
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
     * @param fad        - Fad angives
     * @param antal      - Antallet af flasker der skal oprettes
     * @param milliliter - Antal milliliter, der skal være i hver flaske
     * @param navn       - Navnet på flasken
     */
    public static void createFlasker(Fad fad, int antal, double milliliter, String navn) {
        String batchID = null;
        boolean batchIDExist = true;

        while (batchIDExist) {
            batchID = Utility.randomUUID(16);

            if (Storage.getWhiskyFlasker().size() == 0) {
                batchIDExist = false;
            }

            for (WhiskyFlaske flaske : Storage.getWhiskyFlasker()) {
                System.out.println(!flaske.getBatchID().equals(batchID));
                if (!flaske.getBatchID().equals(batchID)) {
                    batchIDExist = false;
                    break;
                }
            }
        }

        if ((milliliter / 1000) * antal > fad.getLiterIFad()) {
            throw new RuntimeException("Der er ikke nok væske til at lave flasker!");
        }

        fad.setLiterIFad(fad.getLiterIFad() - (milliliter / 1000) * antal);

        for (int i = 0; i < antal; i++) {
            WhiskyFlaske whiskeyFlaske = new WhiskyFlaske(milliliter, navn, batchID);
            whiskeyFlaske.setFad(fad);
            Storage.addWhiskyflasker(whiskeyFlaske);
        }
        WhiskyFlaske.resetIndex();
    }

    /**
     * getWhiskyFlaskerSearch er en søgefunktion der bruges til at søge efter flasker
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


        createDestillering(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 4, 5), "Single malt", "Byg", "Sniper", 500, 60, "Birk", "God whisky");
        createDestillering(LocalDate.of(2023, 3, 28), LocalDate.of(2027, 3, 29), "Single malt", "Hvede", "Adam", 700, 55.5, "Ingen", "Smagen er god");
        Destillering destillering1 = createDestillering(LocalDate.of(2019, 1, 1), LocalDate.of(2022, 4, 5), "Single malt", "Rug", "Mads", 550, 45.6, "Ingen", "Smager lidt af rugbrød");
        Destillering destillering2 = createDestillering(LocalDate.of(2018, 1, 1), LocalDate.of(2023, 1, 1), "Single malt", "Majs", "Tayyip", 800, 61, "Eg", "Lidt for stærk");

        createTap(60, destillering1, fad4);
        createTap(64, destillering2, fad2);

        createFlasker(fad2, 10, 1000, "Golden Whisky");
    }
}
