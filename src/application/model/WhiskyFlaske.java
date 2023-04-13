package application.model;

public class WhiskyFlaske {
    private double kapacitet;
    private final int nummer;
    private static int whiskyNummerIndex = 1;
    private final String navn;
    private final String batchID;
    private Fad fad;

    public WhiskyFlaske(double kapacitet, String navn, String batchID) {
        this.navn = navn;
        this.kapacitet = kapacitet;
        this.batchID = batchID;
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
    public String getBatchID() {
        return batchID;
    }

    public static void resetIndex() {
        WhiskyFlaske.whiskyNummerIndex = 1;
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
        return navn + " - " + "Fadtype: " + fad.getType() + " " + nummer;
    }


}
