public class tarsasjatek {
    private int szabszam;
    private String nev;
    private int raktar;


    public tarsasjatek(int szabszam, String nev, int raktar) {
        this.szabszam = szabszam;
        this.nev = nev;
        this.raktar = raktar;
    }

    public int getSzabszam() {
        return szabszam;
    }

    public void setSzabszam(int szabszam) {
        this.szabszam = szabszam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getRaktar() {
        return raktar;
    }

    public void setRaktar(int raktar) {
        this.raktar = raktar;
    }
}
