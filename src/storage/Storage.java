package storage;

import application.model.Lager;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Lager> lagerer = new ArrayList<>();


    public static void addLager(Lager lager) {
        if (!lagerer.contains(lager)) {
            lagerer.add(lager);
        }
    }

    public static void removeLager(Lager lager) {
        lagerer.remove(lager);
    }

    public static ArrayList<Lager> getLagerer() {
        return lagerer;
    }

}
