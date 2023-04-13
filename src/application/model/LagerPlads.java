package application.model;

public class LagerPlads {
    private final String reol;
    private final String hylde;
    private final String plads;

    public LagerPlads(String reol, String hylde, String plads) {
        this.reol = reol;
        this.hylde = hylde;
        this.plads = plads;
    }

    public String getReol() {
        return reol;
    }

    public String getHylde() {
        return hylde;
    }

    public String getPlads() {
        return plads;
    }
}
