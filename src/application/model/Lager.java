package application.model;

import java.util.ArrayList;

public class Lager {
    private String adresse;
    private double kvm;
    private int fadKapacitet;
    private ArrayList <Fad> fade;

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


}

