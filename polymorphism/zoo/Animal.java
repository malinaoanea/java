package polymorphism.zoo;

public abstract class Animal {
    private int nrIdentificare;
    private String nume;
    private int varsta;
    protected String tipHrana;
    protected String sunetSpecific;

    public Animal(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
        nrIdentificare = hashCode();
    }

    public abstract void seHraneste();

    public abstract  void scoateSunet();

    public  void afiseazaDetalii() {
        System.out.println("Aceasta este " + this.toString() );
    }
    public String toString() {
        return "Animal din cateogoria " + this.getClass().getSuperclass().getSimpleName() +
                ",din specia " + this.getClass().getSimpleName() + " {" +
                " nume " + nume + ", varsta " + varsta +"}" +
                "";
        }

}
