package application.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Lager {
    private String adresse;
    private double kvm;
    private int fadKapacitet;
    private final ArrayList<Fad> fade = new ArrayList<>();

    public Lager(String adresse, double kvm, int fadKapacitet) {
        this.adresse = adresse;
        this.kvm = kvm;
        this.fadKapacitet = fadKapacitet;
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

    public int getFadKapacitet() {
        return fadKapacitet;
    }

    public void setFadKapacitet(int fadKapacitet) {
        this.fadKapacitet = fadKapacitet;
    }

    public ArrayList<Fad> getFade() {
        return fade;
    }

    public void addFad(Fad fad) {
        if (!fade.contains(fad) && fad != null) {
            if (fade.size() < fadKapacitet) {
                fade.add(fad);
                fad.setLager(this);
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

