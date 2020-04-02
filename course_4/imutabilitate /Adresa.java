package imutabilitate;

public class Adresa {
    private String strada;
    private String numar;

    public Adresa(String strada, String numar) {
        this.strada = strada;
        this.numar = numar;
    }

    public String toString() {
        return "Adresa{strada='" + this.strada + "', numar='" + this.numar + "'}";
    }

    public String getNumar() {
        return this.numar;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getStrada() {
        return this.strada;
    }

    public Adresa(Adresa adresa) {
        this(adresa.getStrada(), adresa.getNumar());
    }
}
