package application.controller;

import application.model.Fad;
import application.model.Lager;
import storage.Storage;

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


    //--------------------------------------------------

    public static void addLager(Lager lager) {
        Storage.addLager(lager);
    }

    public static void addFad(Fad fad) {
        Storage.addFad(fad);
    }

    //--------------------------------------------------

    public static void removeLager(Lager lager) {
        Storage.removeLager(lager);
    }

    public static void removeFad(Fad fad) {
        Storage.removeFad(fad);
    }

    //--------------------------------------------------

    public static ArrayList<Lager> getLager() {
        return Storage.getLagerer();
    }

    public static ArrayList<Fad> getFade() {
        return Storage.getFade();
    }

    //--------------------------------------------------

    public static void initController() {
        createFad("Burbon", 32, "Texas");
        createFad("Sherry", 64, "England");
        createFad("Single malt", 120, "USA");
        createFad("Rødvin", 60, "Tyskland");

        createLager("Klostertorvet 11", 52, 100);
        createLager("Rosenhøj 60", 20, 50);
        createLager("Randersvej 243", 200, 1000);
    }
}
