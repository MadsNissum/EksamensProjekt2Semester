package application.model;

import java.util.ArrayList;

public class Fad {
    private String type;
    private double kapacitet;
    private String oprindelse;
    private Lager lager;
    private final int fadNummer;
    private static int index = 1;
    private LagerPlads lagerPlads;

    public Fad(String type, double kapacitet, String oprindelse) {
        this.type = type;
        this.kapacitet = kapacitet;
        this.oprindelse = oprindelse;
        this.fadNummer = index++;
    }

    public void createLagerPlads(String reol, String hylde, String plads) {
        this.lagerPlads = new LagerPlads(reol, hylde, plads);
    }

    public LagerPlads getLagerPlads() {
        return lagerPlads;
    }

    public void setLagerPlads(LagerPlads lagerPlads) {
        this.lagerPlads = lagerPlads;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(double kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOprindelse() {
        return oprindelse;
    }

    public void setOprindelse(String oprindelse) {
        this.oprindelse = oprindelse;
    }

    public void setLager(Lager lager) {
        if (lager == null) {
            this.lager.removeFad(this);
            this.lager = null;
        } else if (this.lager == null || !this.lager.equals(lager)) {
            this.lager = lager;
            lager.addFad(this);
        }
    }

    public Lager getLager() {
        return lager;
    }

    @Override
    public String toString() {
        return fadNummer + " " + type + " Liter: " + kapacitet + " Oprindelse: " + oprindelse ;

    }

    private final ArrayList <Tap> taps = new ArrayList<>();

    public ArrayList <Tap> getTaps() {
        return taps;
    }

    public void addTap(Tap tap) {
        if (!taps.contains(tap) && tap != null) {
            if (tap.getMængde() < getKapacitet()) {
                taps.add(tap);
                tap.setFad(this);
            } else {
                throw new RuntimeException("Der er ikke plads i fadet");
            }
        }
    }
    public void removeTab(Tap tap) {
        taps.remove(tap);
        tap.setDestillering(null);

    }

}


