package application.model;

import java.util.ArrayList;

public class Lager {
    private String adresse;
    private double kvm;
    private int kapacitet;
    private final ArrayList<Fad> fade = new ArrayList<>();

    public Lager(String adresse, double kvm, int kapacitet) {
        this.adresse = adresse;
        this.kvm = kvm;
        this.kapacitet = kapacitet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getKvm() {
        return kvm;
    }

    public void setKvm(double kvm) {
        this.kvm = kvm;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public ArrayList<Fad> getFade() {
        return fade;
    }

    public void addFad(Fad fad) {
        if (!fade.contains(fad) && fad != null) {
            if (fade.size() < kapacitet) {
                fad.setLager(this);
                fade.add(fad);
            } else {
                throw new RuntimeException("Der er ikke plads til flere tynder på lageret!");
            }
        }
    }

    public void removeFad(Fad fad) {
        fade.remove(fad);
        fad.setLager(null);
    }

    @Override
    public String toString() {
        return "Adresse: " + adresse;
    }
}

