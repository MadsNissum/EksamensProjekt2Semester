package application.model;

public class Tap {
    private double liter;
    private Destillering destillering;
    private Fad fad;

    public Tap(double liter) {
        this.liter = liter;
    }

    public double getLiter() {
        return liter;
    }

    public void setLiter(double liter) {
        this.liter = liter;
    }

    public Destillering getDestillering() {
        return destillering;
    }

    public Fad getFad() {
        return fad;
    }

    public void setDestillering(Destillering destillering) {
        if (this.destillering != destillering) {
            Destillering gammeltDestillering = this.destillering;
            if (gammeltDestillering != null) {
                gammeltDestillering.removeTab(this);
            }
            this.destillering = destillering;
            if (destillering != null) {
                destillering.addTap(this);
            }
        }
    }

    //TODO
    /**
     * setFad
     *
     * @param fad - Fad angives
     */

    public void setFad(Fad fad) {
        if (this.fad != fad) {
            Fad gammeltFad = this.fad;
            if (gammeltFad != null) {
                gammeltFad.removeTab(this);
            }
            this.fad = fad;
            if (fad != null) {
                fad.addTap(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Mængde: " + liter + " Fadnummer: " + fad.getFadNummer();
    }
}

