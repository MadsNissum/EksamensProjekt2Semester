package application.model;

public class Tap {
    private double mængde;
    private Destillering destillering;
    private Fad fad;

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
        Destillering gammeltDestillering = null;
        if (this.destillering != destillering) {
            gammeltDestillering = this.destillering;
        }
        if (gammeltDestillering != null) {
            destillering.removeTab(this);
        }
        this.destillering = destillering;
        if (destillering != null) {
            destillering.addTap(this);
        }
    }

    public void setFad(Fad fad) {
        Fad gammeltFad = null;
        if (this.fad != fad) {
            gammeltFad = this.fad;
        }
        if (gammeltFad != null) {
            fad.removeTab(this);
        }
        this.fad = fad;
        if (fad != null) {
            fad.addTap(this);
        }
    }

    @Override
    public String toString() {
        return "Mængde: " + mængde + " Fadnummer: " + fad.getFadNummer();
    }
}

