package storage;

import application.model.Fad;
import application.model.Lager;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Lager> lagerer = new ArrayList<>();

    private static final ArrayList<Fad> fade = new ArrayList<>();


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

    //--------------------------------------------------

    public static void removeLager(Lager lager) {
        lagerer.remove(lager);
    }

    public static void removeFad(Fad fad) {
        fade.remove(fad);
    }

    //--------------------------------------------------

    public static ArrayList<Lager> getLagerer() {
        return lagerer;
    }

    public static ArrayList<Fad> getFade() {
        return fade;
    }

}
