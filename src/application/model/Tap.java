package application.model;

public class Tap {
    private double mængde;
    private Destillering destillering;
    private Fad fad;

    public Tap(double mængde, Destillering destillering, Fad fad) {
        this.mængde = mængde;
        this.destillering= destillering;
        this.fad = fad;

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

    @Override
    public String toString() {
        return "Mængde: " + mængde + " Fadnummer: " + fad.getFadNummer();
    }
}

