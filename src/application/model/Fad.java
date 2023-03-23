package application.model;

public class Fad {
    private String type;
    private double kapacitet;
    private String oprindelse;
    private Lager lager;
    private int fadNummer;
    private static int index = 1;
    private LagerPlads lagerPlads;

    public Fad(String type, double kapacitet, String oprindelse) {
        this.type = type;
        this.kapacitet = kapacitet;
        this.oprindelse = oprindelse;
        this.fadNummer = index++;
    }

    public void createLagerPlads(String reol, String hylde, String plads) {
        LagerPlads lagerPlads = new LagerPlads(reol, hylde, plads);
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
        this.lager = lager;
    }

    public Lager getLager() {
        return lager;
    }



    @Override
    public String toString() {
        return fadNummer + " " + type + " Liter: " + kapacitet + " Oprindelse: " + oprindelse ;

    }
}

