package storage;

import application.model.Destillering;
import application.model.Fad;
import application.model.Lager;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Lager> lagerer = new ArrayList<>();

    private static final ArrayList<Fad> fade = new ArrayList<>();

    private static final ArrayList<Destillering> destilleringer = new ArrayList<>();


    public static void addLager(Lager lager) {
        if (!lagerer.contains(lager)) {
            lagerer.add(lager);
        }
    }

    public static void addFad(Fad fad) {
        if (!fade.contains(fad)) {
            fade.add(fad);
        }
    }

    public static void addDestilleringer(Destillering destillering) {
        if (!destilleringer.contains(destillering)) {
            destilleringer.add(destillering);
        }
    }

    //--------------------------------------------------

    public static void removeLager(Lager lager) {
        lagerer.remove(lager);
    }

    public static void removeFad(Fad fad) {
        fade.remove(fad);
    }

    public static void removeDestilleringer(Destillering destillering) { destilleringer.remove(destillering); }

    //--------------------------------------------------

    public static ArrayList<Lager> getLagerer() {
        return lagerer;
    }

    public static ArrayList<Fad> getFade() {
        return fade;
    }

    public static ArrayList<Destillering> getDestilleringer() {return destilleringer; }

}
