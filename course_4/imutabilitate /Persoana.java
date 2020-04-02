package imutabilitate;

public class Persoana {
    private final int id;
    private final String nume;
    private final Adresa adresa;

    public Persoana(int id, String nume, Adresa adresa) {
        this.id = id;
        this.nume = nume;
        String numarStrada = adresa.getNumar();
        String numeStrada = adresa.getStrada();
        Adresa copieAdresa = new Adresa(numeStrada, numarStrada);
        this.adresa = copieAdresa;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return "Persoana{id=" + this.id + ", nume='" + this.nume + "', adresa=" + this.adresa + "}";
    }

    public Adresa getAdresa() {
        return this.adresa;
    }

    public String getNume() {
        return this.nume;
    }
}
