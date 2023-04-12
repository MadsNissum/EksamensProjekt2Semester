package application.model;

import java.util.ArrayList;

public class Fad {
    private String type;
    private double kapacitet;
    private double literIFad;
    private String oprindelse;
    private final int nummer;
    private static int nummerIndex = 1;
    private Lager lager;
    private LagerPlads lagerPlads;
    private final ArrayList<Tap> taps = new ArrayList<>();
    private final ArrayList<WhiskyFlaske> whiskyFlasker = new ArrayList<>();

    public Fad(String type, double kapacitet, String oprindelse) {
        this.type = type;
        this.kapacitet = kapacitet;
        this.oprindelse = oprindelse;
        this.nummer = nummerIndex++;
        this.literIFad = 0;
    }

    public void createLagerPlads(String reol, String hylde, String plads) {
        this.lagerPlads = new LagerPlads(reol, hylde, plads);
    }

    public void setLiterIFad(double literIFad) {
        this.literIFad = literIFad;
    }

    public double getLiterIFad() {
        return literIFad;
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

    public Lager getLager() {
        return lager;
    }

    public int getNummer() {
        return nummer;
    }

    /**
     * getLedigPladsIFad - Antal liter tilbage efter der er aftappet
     * @return antal liter efter aftapning
     */
    public double getLedigPladsIFad() {
        return kapacitet - literIFad;
    }

    /**
     * getLiterIFad - Antal liter der tappes i fadet
     * @return antal liter der aftappes
     */
    /*
    public double getLiterIFad() {
        double sum = 0;
        for (Tap tap : taps) {
            sum += tap.getLiter();
        }
        return sum;
    }
     */

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

    public ArrayList<WhiskyFlaske> getWhiskyFlasker() {
        return whiskyFlasker;
    }

    public void addWhiskeyFlaske(WhiskyFlaske whiskeyFlaske) {
        if (!whiskyFlasker.contains(whiskeyFlaske) && whiskeyFlaske != null) {
            whiskyFlasker.add(whiskeyFlaske);
            whiskeyFlaske.setFad(this);
        }
    }

    public void removeWhiskeyFlaske(WhiskyFlaske whiskeyFlaske) {
        whiskyFlasker.remove(whiskeyFlaske);
        whiskeyFlaske.setFad(null);

    }

    @Override
    public String toString() {
        return nummer + " " + type + " Liter: " + getLiterIFad() + "/" + kapacitet + " Oprindelse: " + oprindelse;

    }
}


