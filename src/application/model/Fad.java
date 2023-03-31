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
    private final ArrayList<Tap> taps = new ArrayList<>();
    private final ArrayList<WhiskeyFlaske> whiskeyFlasker = new ArrayList<>();

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
        if (this.lager != lager) {
            Lager gammeltLager = this.lager;
            if (gammeltLager != null) {
                gammeltLager.removeFad(this);
            }
            this.lager = lager;
            if (lager != null) {
                lager.addFad(this);
            }
        }
    }

    /*
    OLD:
    if (lager == null) {
            this.lager.removeFad(this);
            this.lager = null;
        } else if (this.lager == null || !this.lager.equals(lager)) {
            this.lager = lager;
            lager.addFad(this);
        }
     */

    public Lager getLager() {
        return lager;
    }

    public int getFadNummer() {
        return fadNummer;
    }

    public double getLedigPladsIFad() {
        return kapacitet - getLiterIFad();
    }

    public double getLiterIFad() {
        double sum = 0;
        for (Tap tap : taps) {
            sum += tap.getLiter();
        }
        return sum;
    }

    //------------------------------------------------------- Linkattribut til Tap


    public ArrayList<Tap> getTaps() {
        return taps;
    }

    public void addTap(Tap tap) {
        if (!taps.contains(tap) && tap != null) {
            if (tap.getLiter() <= getLedigPladsIFad()) {
                taps.add(tap);
                tap.setFad(this);
            } else {
                throw new RuntimeException("Der er ikke plads i fadet");
            }
        }
    }

    public void removeTab(Tap tap) {
        taps.remove(tap);
        tap.setFad(null);

    }

    //---------------------------------------------------- Linkattribut til WhiskeyFlask

    public ArrayList<WhiskeyFlaske> getWhiskeyFlasker() {
        return whiskeyFlasker;
    }

    public void addWhiskeyFlaske(WhiskeyFlaske whiskeyFlaske) {
        if (!whiskeyFlasker.contains(whiskeyFlaske) && whiskeyFlaske != null) {
            whiskeyFlasker.add(whiskeyFlaske);
            whiskeyFlaske.setFad(this);
        }
    }

    public void removeWhiskeyFlaske(WhiskeyFlaske whiskeyFlaske) {
        whiskeyFlasker.remove(whiskeyFlaske);
        whiskeyFlaske.setFad(null);

    }

    @Override
    public String toString() {
        return fadNummer + " " + type + " Liter: " + getLiterIFad() + "/" + kapacitet + " Oprindelse: " + oprindelse;

    }
}


