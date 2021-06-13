public class Tuote {
    private String nimi;
    private int kpl;
    private double hinta;
    private String kuvaus;

    public Tuote(String nimi, int kpl, double hinta,String kuvaus) {
        this.nimi = nimi;
        this.kpl = kpl;
        this.hinta = hinta;
        this.kuvaus = kuvaus;
    }

    public Tuote() {
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public String getNimi() {
        return nimi;
    }



    public int getKpl() {
        return kpl;
    }



    public double getHinta() {
        return hinta;
    }


}
