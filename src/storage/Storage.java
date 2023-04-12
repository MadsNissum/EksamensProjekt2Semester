package storage;

import application.model.*;


import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Lager> lagerer = new ArrayList<>();

    private static final ArrayList<Fad> fade = new ArrayList<>();

    private static final ArrayList<Destillering> destilleringer = new ArrayList<>();
    private static final ArrayList<Tap> taps = new ArrayList<>();

    private static final ArrayList<WhiskyFlaske> whiskyFlasker = new ArrayList<>();


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

    public static void addTap(Tap tap) {
        if (!taps.contains(tap)) {
            taps.add(tap);
        }
    }

    public static void addWhiskyflasker(WhiskyFlaske whiskeyFlaske) {
        if (!whiskyFlasker.contains(whiskeyFlaske)) {
            whiskyFlasker.add(whiskeyFlaske);
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

    public static void removeTap(Tap tap) {
        taps.remove(tap);
    }

    public static void removeWhiskyflaske(WhiskyFlaske whiskeyFlaske) {
        whiskyFlasker.remove(whiskeyFlaske);
    }
    //--------------------------------------------------

    public static ArrayList<Lager> getLagerer() {
        return lagerer;
    }

    public static ArrayList<Fad> getFade() {
        return fade;
    }

    public static ArrayList<Destillering> getDestilleringer() {return destilleringer; }

    public static ArrayList<Tap> getTaps() {
        return taps;
    }

    public static ArrayList<WhiskyFlaske> getWhiskyFlasker() {
        return whiskyFlasker;
    }
}
