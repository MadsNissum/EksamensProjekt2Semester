package application.model;

public class LagerPlads {
    private String reol;
    private String hylde;
    private String plads;


    public LagerPlads(String reol, String hylde, String plads) {
        this.reol = reol;
        this.hylde = hylde;
        this.plads = plads;
    }

    public String getReol() {
        return reol;
    }

    public void setReol(String reol) {
        this.reol = reol;
    }

    public String getHylde() {
        return hylde;
    }

    public void setHylde(String hylde) {
        this.hylde = hylde;
    }

    public String getPlads() {
        return plads;
    }

    public void setPlads(String plads) {
        this.plads = plads;
    }
}
