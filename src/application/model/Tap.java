package application.model;

import java.util.ArrayList;

public class Tap {
    private double mængde;
    private Destillering destillering;
    private Fad fad;
    private final ArrayList<Destillering> destilleringer = new ArrayList<>();
    private final ArrayList<Fad> fade = new ArrayList<>();

    public Tap(double mængde) {
        this.mængde = mængde;

    }

    public double getMængde() {
        return mængde;
    }

    public void setMængde(double mængde) {
        this.mængde = mængde;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public Fad getFad() {
        return fad;
    }

    public void setDestillering(Destillering destillering) {
        if (destillering == null) {
            this.destillering.removeTab(this);
            this.destillering = null;
        } else if (this.destillering == null || !this.destillering.equals(destillering)) {
            this.destillering = destillering;
            destillering.addTap(this);
        }
    }

    public void setFad(Fad fad) {
        if (fad == null) {
            this.fad.removeTab(this);
            this.fad = null;
        } else if (this.fad == null || !this.fad.equals(fad)) {
            this.fad = fad;
            fad.addTap(this);
        }
    }

    /*


    public ArrayList <Destillering> getDestilleringer() {
        return destilleringer;
    }


    public void addDestilleringer(Destillering destillering) {
        if (!destilleringer.contains(destillering) && destillering != null) {
            destilleringer.add(destillering);
            destillering.setTap(this);
        }
    }
    public void removeDestillering(Destillering destillering) {
        destilleringer.remove(destillering);
        destillering.setTap(null);
    }

    public ArrayList <Fad> getFade() {
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

     */
}

