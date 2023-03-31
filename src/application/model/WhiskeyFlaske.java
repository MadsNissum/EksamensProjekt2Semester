package application.model;

public class WhiskeyFlaske {
    private double kapacitet;
    private final int nummer;
    private static int whiskyNummerIndex = 1;
    private Fad fad;

    public WhiskeyFlaske(double kapacitet) {
        this.kapacitet = kapacitet;
        this.nummer = whiskyNummerIndex++;
    }

    public double getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(double kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getNummer() {
        return nummer;
    }

    //----------------------------------------------------------- Linkattribut til Fad
    public Fad getFad() {
        return fad;
    }

    public void setFad(Fad fad) {
        if (fad == null) {
            this.fad.removeWhiskeyFlaske(this);
            this.fad = null;
        } else if (this.fad == null || !this.fad.equals(fad)) {
            this.fad = fad;
            fad.addWhiskeyFlaske(this);
        }
    }

    //------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return fad.getType() + " " + nummer;
    }
}
