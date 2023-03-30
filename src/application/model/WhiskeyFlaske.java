package application.model;

public class WhiskeyFlaske {
    private double mængde;
    private final int nummer;
    private static int whiskeyNummerIndex = 1;
    private Fad fad;

    public WhiskeyFlaske(double mængde, int nummer) {
        this.mængde = mængde;
        this.nummer = whiskeyNummerIndex++;
    }

    public double getMængde() {
        return mængde;
    }

    public void setMængde(double mængde) {
        this.mængde = mængde;
    }

    public int getNummer() {
        return nummer;
    }

    public static int getWhiskeyNummerIndex() {
        return whiskeyNummerIndex;
    }

    public static void setWhiskeyNummerIndex(int whiskeyNummerIndex) {
        WhiskeyFlaske.whiskeyNummerIndex = whiskeyNummerIndex;
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
        return mængde + " " + nummer + " " + fad;
    }
}
