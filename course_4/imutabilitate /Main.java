package imutabilitate;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Adresa domiciuliu = new Adresa("Timisioara", "4A");
        Persoana persoana = new Persoana(1, "Teo", domiciuliu);
        String numePersoana = persoana.getNume().toUpperCase();
        System.out.println(persoana);
        System.out.println(numePersoana);
        String stradaUpperCase = domiciuliu.getStrada().toUpperCase();
        domiciuliu.setStrada(stradaUpperCase);
        System.out.println(persoana);
        Adresa adresaDomiciliu = persoana.getAdresa();
        adresaDomiciliu.setStrada(adresaDomiciliu.getStrada().toUpperCase());
        System.out.println(persoana);
    }
}
