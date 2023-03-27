package application.model;

import javafx.scene.control.Tab;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {
    private LocalDate startDato;
    private LocalDate slutDato;
    private String maltbatch;
    private String kornsort;
    private String medarbejder;
    private double mændge;
    private double alkoholProcent;
    private String rygemateriale;
    private String kommentar;

    private final ArrayList <Tap> taps = new ArrayList<>();
    //private Tap tap;


    public Destillering(LocalDate startDato, LocalDate slutDato, String maltbatch,
                        String kornsort, String medarbejder, double mændge, double alkoholProcent,
                        String rygemateriale, String kommentar) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.maltbatch = maltbatch;
        this.kornsort = kornsort;
        this.medarbejder = medarbejder;
        this.mændge = mændge;
        this.alkoholProcent = alkoholProcent;
        this.rygemateriale = rygemateriale;
        this.kommentar = kommentar;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public String getMaltbatch() {
        return maltbatch;
    }

    public void setMaltbatch(String maltbatch) {
        this.maltbatch = maltbatch;
    }

    public String getKornsort() {
        return kornsort;
    }

    public void setKornsort(String kornsort) {
        this.kornsort = kornsort;
    }

    public String getMedarbejder() {
        return medarbejder;
    }

    public void setMedarbejder(String medarbejder) {
        this.medarbejder = medarbejder;
    }

    public double getMændge() {
        return mændge;
    }

    public void setMændge(double mændge) {
        this.mændge = mændge;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public void setAlkoholProcent(double alkoholProcent) {
        this.alkoholProcent = alkoholProcent;
    }

    public String getRygemateriale() {
        return rygemateriale;
    }

    public void setRygemateriale(String rygemateriale) {
        this.rygemateriale = rygemateriale;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public ArrayList <Tap> getTaps() {
        return taps;
    }

    public void addTap(Tap tap) {
        if (!taps.contains(tap) && tap != null) {
            taps.add(tap);
            tap.setDestillering(this);
        }
    }
    public void removeTab(Tap tap) {
        taps.remove(tap);
        tap.setDestillering(null);
    }

    @Override
    public String toString() {return "Kornsort: " + kornsort + " Mængde: " + mændge;}

    /*

    public void setTap(Tap tap) {
        if (tap == null) {
            this.tap.removeDestillering(this);
            this.tap = null;
        } else if (this.tap == null || !this.tap.equals(tap)) {
            this.tap = tap;
            tap.addDestilleringer(this);
        }
    }

    */
}
