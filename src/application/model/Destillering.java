package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {
    private LocalDate startDato;
    private LocalDate slutDato;
    private String maltbatch;
    private String kornsort;
    private String medarbejder;
    private double kapacitet;
    private double alkoholProcent;
    private String rygemateriale;
    private String kommentar;
    private final ArrayList <Tap> taps = new ArrayList<>();


    public Destillering(LocalDate startDato, LocalDate slutDato, String maltbatch,
                        String kornsort, String medarbejder, double liter, double alkoholProcent,
                        String rygemateriale, String kommentar) {
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.maltbatch = maltbatch;
        this.kornsort = kornsort;
        this.medarbejder = medarbejder;
        this.kapacitet = liter;
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

    public double getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(double kapacitet) {
        this.kapacitet = kapacitet;
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

    /**
     * getLiterTilbageIDestllering returnerer hvor mange liter der
     *  er tilbage i destilleringen
     *
     * @return antal liter
     */
    public double getLiterTilbageIDestillering() {
        return kapacitet - getLedigLiterIDestillering();
    }

    /**
     * getLedigLiterIDestillering returnerer det antal liter, der er aftappet
     *
     * @return aftappet liter
     */
    public double getLedigLiterIDestillering() {
        double sum = 0;

        for (Tap tap : taps) {
            sum += tap.getLiter();
        }

        return sum;
    }

    @Override
    public String toString() {
        return String.format("Kornsort: %-10s Mængde: %s", kornsort, kapacitet);
    }
}
