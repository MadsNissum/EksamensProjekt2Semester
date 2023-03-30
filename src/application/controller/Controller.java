package application.controller;

import application.model.Destillering;
import application.model.Fad;
import application.model.Lager;
import application.model.Tap;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Fad createFad(String type, double kapacitet, String oprindelse) {
        Fad fad = new Fad(type, kapacitet, oprindelse);
        Storage.addFad(fad);
        return fad;
    }

    public static Lager createLager(String adresse, double kvm, int fadKapacitet) {
        Lager lager = new Lager(adresse, kvm, fadKapacitet);
        Storage.addLager(lager);
        return lager;
    }

    public static Destillering createDestillering(LocalDate startDato, LocalDate slutDato, String maltbatch, String kornsort, String medarbejder, double mændge, double alkoholProcent, String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(startDato, slutDato, maltbatch, kornsort, medarbejder, mændge, alkoholProcent, rygemateriale, kommentar);
        Storage.addDestilleringer(destillering);
        return destillering;
    }

    public static Tap createTap(double mængde, Destillering destillering, Fad fad) {
        Tap tap = new Tap(mængde);
        tap.setDestillering(destillering);
        tap.setFad(fad);
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
    //--------------------------------------------------

    public static ArrayList<Lager> getLager() {
        return Storage.getLagerer();
    }

    public static ArrayList<Fad> getFade() {
        return Storage.getFade();
    }

    public static ArrayList<Destillering> getDestilleringer() {
        return Storage.getDestilleringer();
    }

    public static ArrayList<Tap> getTaps() {
        return Storage.getTaps();
    }

    //--------------------------------------------------

    public static void updateFad(Fad fad, String type, double kapacitet, String oprindelse) {
        fad.setType(type);
        fad.setKapacitet(kapacitet);
        fad.setOprindelse(oprindelse);
    }

    public static void createLagerPlads(Fad fad, String reol, String hylde, String plads) {
        fad.createLagerPlads(reol, hylde, plads);
    }

    public static void addFadTilLager(Fad fad, Lager lager) {
        fad.setLager(lager);
    }

    public static void updateLager(Lager lager, String adresse, double kvm, int kapacitet) {
        lager.setAdresse(adresse);
        lager.setKvm(kvm);
        lager.setFadKapacitet(kapacitet);
    }

    public static void updateDestillering(Destillering destillering, LocalDate startDato, LocalDate slutDato, String maltbatch,
                                          String kornsort, String medarbejder, double mængde, double alkoholProcent,
                                          String rygemateriale, String kommentar) {
        destillering.setStartDato(startDato);
        destillering.setSlutDato(slutDato);
        destillering.setMaltbatch(maltbatch);
        destillering.setKornsort(kornsort);
        destillering.setMedarbejder(medarbejder);
        destillering.setMændge(mængde);
        destillering.setAlkoholProcent(alkoholProcent);
        destillering.setRygemateriale(rygemateriale);
        destillering.setKommentar(kommentar);
    }

    public static double destillatAftap(Destillering destillering, double mængde) {
       return destillering.getMændge() - mængde;
    }

    public static double aftapFad(Fad fad, double mængde) {
        return fad.getKapacitet() - mængde;
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

        Destillering destillering1 = createDestillering(LocalDate.of(2023, 3, 27), LocalDate.of(2023, 4, 5), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky");

        Tap tap1 = createTap(60,destillering1,fad4);
        System.out.println(Storage.getTaps());
    }
}
