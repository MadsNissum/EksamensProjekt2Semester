package application.controller;

import application.model.Destillering;
import application.model.Fad;
import application.model.Lager;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static void createFad(String type, double kapacitet, String oprindelse) {
        Fad fad = new Fad(type, kapacitet, oprindelse);
        Storage.addFad(fad);
    }

    public static void createLager(String adresse, double kvm, int fadKapacitet) {
        Lager lager = new Lager(adresse, kvm, fadKapacitet);
        Storage.addLager(lager);
    }

    public static void createDestillering(LocalDate startDato, LocalDate slutDato, String maltbatch,
                                          String kornsort, String medarbejder, double mændge, double alkoholProcent,
                                          String rygemateriale, String kommentar) {
        Destillering destillering = new Destillering(startDato,slutDato,maltbatch,kornsort, medarbejder, mændge, alkoholProcent, rygemateriale, kommentar);
        Storage.addDestilleringer(destillering);

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

    public static ArrayList<Destillering> getDestilleringer() {
        return Storage.getDestilleringer();
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


    public static void initController() {
        createFad("Burbon", 32, "Texas");
        createFad("Sherry", 64, "England");
        createFad("Single malt", 120, "USA");
        createFad("Rødvin", 60, "Tyskland");

        createLager("Klostertorvet 11", 52, 100);
        createLager("Rosenhøj 60", 20, 50);
        createLager("Randersvej 243", 200, 1000);

        createDestillering(LocalDate.of(2023, 3,27), LocalDate.of(2023,4, 5), "Single malt", "Byg", "Snævar aka Sniper", 500, 80, "Birk", "God whisky" );
    }
}
